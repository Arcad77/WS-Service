package api.<ru.test>.bgbilling.service.impl;

/*
** Первый автор Phricker 
** http://wiki.bitel.ru/index.php/%D0%9F%D1%80%D0%B8%D0%BC%D0%B5%D1%80_%D0%B8%D0%BD%D1%82%D0%B5%D0%B3%D1%80%D0%B0%D1%86%D0%B8%D0%B8_%D1%81_1%D0%A1_%D1%87%D0%B5%D1%80%D0%B5%D0%B7_custom_API
**
** Переработка Arcad (Arcad77)
**
** <text> подрежит точно замене под ваши нужды
**
**# http://host[:port]/[context/]api/[module]/[service]
**# [context/] = обычно bgbilling/ (если не меняли в конфиге)
**# [module] = для класса выше ru.company.bgbilling.service
**# [service] = для класса выше ContractService
**# http://192.168.10.68:8080/bgbilling/api/<ru.test>.bgbilling.service/ContractList
**# http://192.168.10.68:8080/bgbilling/api/<ru.test>.bgbilling.service/ContractList?wsdl
*/
import ru.bitel.bgbilling.kernel.container.service.server.AbstractService;
import ru.bitel.common.Utils;
 
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
@WebService(name = "ContractList", targetNamespace = "http://<wsserver.test.ru>/", serviceName = "ContractList")
@XmlSeeAlso({
        Agent1C.class, GetAgentListResponse.class
})
public class ContractListImpl extends AbstractService {
 
    @WebMethod(operationName = "GetAgentList", action = "http://<wsserver.test.ru>/GetAgentList")
    @WebResult(name = "GetAgentListResult", targetNamespace = "http://<wsserver.test.ru>/")
    public GetAgentListResponse.GetAgentListResult getAgentList(
            @WebParam(name = "fc", targetNamespace = "http://<wsserver.test.ru>/")
            	String fc,
            @WebParam(name = "formatFIO", targetNamespace = "http://<wsserver.test.ru>/")
            	String formatFIO,
            @WebParam(name = "ContractOpen", targetNamespace = "http://<wsserver.test.ru>/")
            	String ContractOpen,
            @WebParam(name = "ContractID", targetNamespace = "http://<wsserver.test.ru>/")
            	String ContractID,
            @WebParam(name = "wsfTitle", targetNamespace = "http://<wsserver.test.ru>/")
            	String wsfTitle )
    {
        Connection con = getConnection();
        GetAgentListResponse.GetAgentListResult result = new GetAgentListResponse.GetAgentListResult();
        String qf_fc = "";
        String qf_cOpen = "";
        String qf_Title = "";
        String qf_ContractID = "";

        qf_fc = ("".equals(fc)) ? "" : ("1".equals(fc)) ? " c.fc='1' AND " : " c.fc='0' AND ";
        qf_cOpen = ("".equals(ContractOpen)) ? "AND c.date2 IS NULL " : ("1".equals(ContractOpen)) ? "AND c.date2 IS NOT NULL " : "";
        qf_ContractID = (ContractID.equals("")) ? "" : "c.id=" + ContractID + " AND ";
        qf_Title = ("".equals(wsfTitle)) ? "" : ("ALL".equals(wsfTitle)) ? "" : "c.title LIKE '%" + Utils.maskNull(wsfTitle) + "%' AND ";
 		
        String query =  " SELECT c.id AS ID_contract, c.date1 AS From_Date, c.date2 AS To_Date, c.title AS ContractTitle, " +
         	" c.comment, addr_con.address AS Address_conect, addr_pas.address AS Address_pasport, " +
         	" fam.val AS Fio_1, im.val AS fIo_2, otch.val AS fiO_3, " +
         	" pasp.val AS Pasport, inn.val AS INN, crmid.val AS BGCRM_id" +
         	" FROM contract AS c " +
         	" LEFT JOIN contract_parameter_type_1 AS fam ON c.id = fam.cid AND fam.pid = 1 " +
         	" LEFT JOIN contract_parameter_type_1 AS im ON c.id = im.cid AND im.pid = 2 " +
         	" LEFT JOIN contract_parameter_type_1 AS otch ON c.id = otch.cid AND otch.pid = 3  " +
         	" LEFT JOIN contract_parameter_type_1 AS pasp ON c.id = pasp.cid AND pasp.pid = 5  " +
         	" LEFT JOIN contract_parameter_type_1 AS inn ON c.id = inn.cid AND inn.pid = 14 " +
         	" LEFT JOIN contract_parameter_type_1 AS crmid ON c.id = crmid.cid AND crmid.pid = 19  " +
         	" LEFT JOIN contract_parameter_type_2 AS addr_con ON c.id = addr_con.cid AND addr_con.pid = 4  " +
         	" LEFT JOIN contract_parameter_type_2 AS addr_pas ON c.id = addr_pas.cid AND addr_pas.pid = 18  " +
         	" WHERE " + // фильтрация
         	qf_fc +
         	qf_Title +
         	qf_ContractID +
         	" c.scid <= 0 AND " +
         	" fam.cid IS NOT NULL " +
         	qf_cOpen +
         	" LIMIT 10 ";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
            	
               	String ID_contract = rs.getString("ID_contract");
               	String From_Date = Utils.maskNull(rs.getString("From_Date"));
               	String To_Date = Utils.maskNull(rs.getString("To_Date"));
               	String ContractTitle = Utils.maskNull(rs.getString("ContractTitle"));
               	String Comment = Utils.maskNull(rs.getString("c.comment"));
              	String Address_connect = Utils.maskNull(rs.getString("Address_conect"));
              	String Address_pasport = Utils.maskNull(rs.getString("Address_pasport"));
				String Fio_1 = Utils.maskNull(rs.getString("Fio_1"));
               	String fIo_2 = Utils.maskNull(rs.getString("fIo_2"));
               	String fiO_3 = Utils.maskNull(rs.getString("fiO_3"));
               	String Pasport = Utils.maskNull(rs.getString("Pasport"));
               	String INN = Utils.maskNull(rs.getString("INN"));
               	String BGCRM_id = Utils.maskNull(rs.getString("BGCRM_id"));
 
				
                Agent1C agent = new Agent1C();
                agent.setContractId(ID_contract);
                agent.setContractTitle(ContractTitle);
                agent.setContractComment(Comment);                                
                agent.setContractFData1(From_Date);
                agent.setContractFData2(To_Date);
                agent.setAddressConnect(Address_connect);
                agent.setAddressPasport(Address_pasport);
                agent.setFIO(Fio_1, fIo_2, fiO_3, formatFIO);
                agent.setPasport(Pasport);
                agent.setINN(INN);
                agent.setBGCRM_ID(BGCRM_id);
                result.getAgents().add(agent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return result;
    }
}	
