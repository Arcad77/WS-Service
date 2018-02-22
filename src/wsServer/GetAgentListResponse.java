package api.<wsserver>.bgbilling.service.impl;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"getAgentListResult"}, namespace = "http://bgb-1c.vtvs.uz/")
@XmlRootElement(name = "GetAgentListResponse", namespace = "http://bgb-1c.vtvs.uz/")
public class GetAgentListResponse {
 
    @XmlElement(name = "GetAgentListResult")
    protected GetAgentListResponse.GetAgentListResult getAgentListResult;
 
 
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"agents"})
    public static class GetAgentListResult {
 
        @XmlMixed
        @XmlAnyElement(lax = true)
        protected ArrayList<Agent1C> agents;
 
        public ArrayList<Agent1C> getAgents() {
            if (agents == null) {
                agents = new ArrayList<Agent1C>();
            }
            return this.agents;
        }
    }
}
