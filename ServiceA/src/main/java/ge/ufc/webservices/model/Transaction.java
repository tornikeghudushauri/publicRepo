package ge.ufc.webservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Timestamp;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaction", propOrder = { "systemTransactionId", "agentId", "agentTransactionId","userId", "amount", "transactionDate"})
public class Transaction {

    private int systemTransactionId;
    private int agentId;
    private String agentTransactionId;
    private int userId;
    private double amount;
    private Timestamp transactionDate;

    public Transaction(int systemTransactionId, int agentId, String agentTransactionId, int userId, double amount, Timestamp transactionDate) {
        this.systemTransactionId = systemTransactionId;
        this.agentId = agentId;
        this.agentTransactionId = agentTransactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }

    public int getSystemTransactionId() {
        return systemTransactionId;
    }

    public void setSystemTransactionId(int systemTransactionId) {
        this.systemTransactionId = systemTransactionId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

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

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "systemTransactionId=" + systemTransactionId +
                ", agentId=" + agentId +
                ", agentTransactionId='" + agentTransactionId + '\'' +
                ", userId=" + userId +
                ", amount=" + amount +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}