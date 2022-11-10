package ge.ufc.webservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agent", propOrder = { "agentId", "name", "password" })
public class Agent {
    private int agentId;
    private String name;
    private String password;

    public Agent(int agentId, String name, String password) {
        this.agentId = agentId;
        this.name = name;
        this.password = password;
    }

    public Agent() {
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}