package api.<ru.test>.bgbilling.service.impl;

/*
**
** Зачем именно этот фаил и почему не реализован по другому знает только Phricker
**
*/

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"getAgentListResult"}, namespace = "http://<wsserver.test.ru>/")
@XmlRootElement(name = "GetAgentListResponse", namespace = "http://<wsserver.test.ru>/")
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
