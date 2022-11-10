package ge.ufc.webservices.ws;

import ge.ufc.webservices.dao.DatabaseException;
import ge.ufc.webservices.dao.DatabaseManager;
import ge.ufc.webservices.dao.ServiceADao;
import ge.ufc.webservices.dao.ServiceADaoImpl;
import ge.ufc.webservices.exception.AgentAuthFailed;
import ge.ufc.webservices.exception.AmountNotPositive;
import ge.ufc.webservices.exception.TransactionNotFound;
import ge.ufc.webservices.exception.UserNotFound;
import ge.ufc.webservices.model.*;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.sql.Connection;


@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService
public class ServiceA {

    @Resource
    private WebServiceContext wsContext;

    @WebMethod(operationName = "check")
    @WebResult(name = "checkResult")
    public CheckResponse check(@WebParam(name = "CheckRequest") CheckRequest checkRequest) throws AgentAuthFailed {

        Connection connection;
        CheckResponse checkResponse = new CheckResponse();
        ;
        try {
            connection = DatabaseManager.getDatabaseConnection();
            ServiceADao serviceADao = new ServiceADaoImpl(connection);
            User result = serviceADao.check(checkRequest.getUserId());
            checkResponse.setFullName(result.getFirstName().charAt(0) + "." + result.getLastName().charAt(0) + ". Balance=" + result.getBalance());
            return checkResponse;
        } catch (DatabaseException | UserNotFound e) {
            throw new RuntimeException();
        }

    }


    @WebMethod(operationName = "pay")
    @WebResult(name = "payResult")
    public PayResponse pay(@WebParam(name = "PayRequest") PayRequest payRequest) throws AmountNotPositive {


        if(payRequest.getAmount()<=0) {
            throw new AmountNotPositive();
        }

        Connection connection;
        try{
            connection = DatabaseManager.getDatabaseConnection();
            ServiceADao serviceADao = new ServiceADaoImpl(connection);
            int systemTransactionId = serviceADao.pay(payRequest.getAgentTransactionId(), payRequest.getUserId(), payRequest.getAmount());
            PayResponse payResponse = new PayResponse();
            payResponse.setSystemTransactionId(systemTransactionId);
            return payResponse;
        } catch (DatabaseException | UserNotFound | TransactionNotFound e) {
            throw new RuntimeException();
        }
    }

    @WebMethod(operationName = "status")
    @WebResult(name = "statusResult")
    public StatusResponse status(@WebParam (name = "StatusRequest") StatusRequest statusRequest) throws AgentAuthFailed {


        Connection connection;
        StatusResponse statusResponse = new StatusResponse();
        ;
        try {
            connection = DatabaseManager.getDatabaseConnection();
            ServiceADao serviceADao = new ServiceADaoImpl(connection);
            Transaction result = serviceADao.status(statusRequest.getAgentTransactionId());
            statusResponse.setSystemTransactionId(result.getSystemTransactionId());
            return statusResponse;
        } catch (DatabaseException | TransactionNotFound e) {
            throw new RuntimeException();
        }

    }


    private boolean isValid() {
        Connection connection;
        HttpServletRequest request = (HttpServletRequest) wsContext.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        String name = request.getHeader("agent");
        String agentPass = request.getHeader("password");
        try {
            connection = DatabaseManager.getDatabaseConnection();
            ServiceADao serviceADao = new ServiceADaoImpl(connection);
            return serviceADao.checkAgent(name, agentPass);
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }
    }
}