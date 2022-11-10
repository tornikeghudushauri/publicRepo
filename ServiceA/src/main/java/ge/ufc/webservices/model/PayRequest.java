package ge.ufc.webservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class PayRequest {

    private String agentTransactionId;
    private int userId;
    private double amount;



    public String getAgentTransactionId() {
        return agentTransactionId;
    }

    public void setAgentTransactionId(String agentTransactionId) {
        this.agentTransactionId = agentTransactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayRequest{" +
                "agentTransactionId='" + agentTransactionId + '\'' +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}