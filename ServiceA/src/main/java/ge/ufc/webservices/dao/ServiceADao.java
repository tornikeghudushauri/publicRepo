package ge.ufc.webservices.dao;

import ge.ufc.webservices.exception.TransactionNotFound;
import ge.ufc.webservices.exception.UserNotFound;
import ge.ufc.webservices.model.Transaction;
import ge.ufc.webservices.model.User;

public interface ServiceADao {

    User check(int userId) throws UserNotFound, DatabaseException;

    int pay (String transactionId, int userId,double amount) throws UserNotFound, DatabaseException, TransactionNotFound;

    boolean checkAgent (String agentId, String password);

    boolean checkAgentIp (String agentId, String agentIp);

    Transaction status (String agentTransactionId) throws TransactionNotFound, DatabaseException;
}