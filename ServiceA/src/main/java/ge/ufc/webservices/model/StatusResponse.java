package ge.ufc.webservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class StatusResponse {

    @XmlElement(name = "systemTransactionId")
    private int systemTransactionId;

    public int getSystemTransactionId() {
        return systemTransactionId;
    }

    public void setSystemTransactionId(int systemTransactionId) {
        this.systemTransactionId = systemTransactionId;
    }
}