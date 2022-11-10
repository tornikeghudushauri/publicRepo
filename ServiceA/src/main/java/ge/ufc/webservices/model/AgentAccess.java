package ge.ufc.webservices.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agentAccess", propOrder = { "rowId", "allowedIP", "agentId" })
public class AgentAccess {

    private int rowId;
    private String allowedIP;
    private int agentId;

    public AgentAccess(int rowId, String allowedIP, int agentId) {
        this.rowId = rowId;
        this.allowedIP = allowedIP;
        this.agentId = agentId;
    }

    public AgentAccess() {
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getAllowedIP() {
        return allowedIP;
    }

    public void setAllowedIP(String allowedIP) {
        this.allowedIP = allowedIP;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}