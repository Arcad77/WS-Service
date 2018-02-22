package api.<ru.test>.bgbilling.service.impl;

/*
**
** Класс предобработки отправляемых данных.
** Исключены ошибки при передаче данных на сторону клиента
** Не по всем конечно переменным, просто некоторые не должны быть пустыми по определению
** а те что всегда могут быть пустыми предусмотрительно обработаны.
** 
*/

import javax.xml.bind.annotation.*;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {	
	"ContractId", "ContractTitle", "ContractComment", "ContractFData1", "ContractFData2",
	"AddressConnect", "AddressPasport", "FIO", "Pasport", "INN", "BGCRM_id"},
		namespace = "http://<wsserver.test.ru>/")
@XmlRootElement(name = "Agent1C", namespace = "http://<wsserver.test.ru>/")
public class Agent1C {
    @XmlElement(name = "ContractId")
    protected String ContractId;
    @XmlElement(name = "ContractTitle")
    protected String ContractTitle;
    @XmlElement(name = "ContractComment")
    protected String ContractComment;
    @XmlElement(name = "ContractFData1")
    protected String ContractFData1;
    @XmlElement(name = "ContractFData2")
    protected String ContractFData2;
    @XmlElement(name = "AddressConnect")
    protected String AddressConnect;
    @XmlElement(name = "AddressPasport")
    protected String AddressPasport;    
    @XmlElement(name = "FIO")
    protected String FIO;
    @XmlElement(name = "Pasport")
    protected String Pasport;
    @XmlElement(name = "INN")
    protected String INN;
    @XmlElement(name = "BGCRM_id")
    protected String BGCRM_id;
    

//# agent.setContractId(contractId);
    public String getContractId() {
        return this.ContractId;
    }
 
    public void setContractId(String value) {
        this.ContractId = value;
    }
    
//# agent.setContractTitle(ContractTitle); 
    public String getContractTitle() {
        return this.ContractTitle;
    }
 
    public void setContractTitle(String value) {
        this.ContractTitle = value;
    }

//# agent.setContractComment(ContractComment); 
    public String getContractComment() {
        return this.ContractComment;
    }
 
    public void setContractComment(String value) {
        this.ContractComment = value;
    }

//# agent.setContractFData1(ContractFData1); 
    public String getContractFData1() {
        return this.ContractFData1;
    }
 
    public void setContractFData1(String value) {
        this.ContractFData1 = value;
    }
    
//# agent.setContractFData2(ContractFData2); 
    public String getContractFData2() {
        return this.ContractFData2;
    }
 
    public void setContractFData2(String value) {
        this.ContractFData2 = ("".equals(value)) ? "Открытый договор" : value;
    }
    
//# agent.setAddressConnect(Address_connect);
    public String getAddressConnect() {
        return this.AddressConnect;
    }
 
    public void setAddressConnect(String value) {
        this.AddressConnect = ("".equals(value)) ? "Адрес не указан" : value;
    }
    
//# agent.setAddressPasport(Address_pasport);
    public String getAddressPasport() {
        return this.AddressPasport;
    }
 
    public void setAddressPasport(String value) {
        this.AddressPasport = ("".equals(value)) ? "Адрес не указан" : value;
    }    

//# agent.setFIO(Fio, fIo, fiO);
    public String getFIO() {
        return this.FIO;
    }
 
    public void setFIO(String Fio, String fIo, String fiO, String FormatFIO) {
		String s_fIo = ("".equals(fIo)) ? "" : fIo.substring(0,1) + ". ";
		String s_fiO = ("".equals(fiO)) ? "" : fiO.substring(0,1) + ".";
    	this.FIO = (("Full".equals(FormatFIO)) ? (Fio + " " + fIo + " " + fiO) : (Fio + " " + s_fIo + s_fiO));
    }
    
//# agent.setPasport(Pasport);
    public String getPasport() {
        return this.Pasport;
    }
 
    public void setPasport(String value) {
        this.Pasport = ("".equals(value)) ? "Паспорт не указан" : value;
    }
 
//# agent.setINN(INN);
    public String getINN() {
        return this.INN;
    }
 
    public void setINN(String value) {
        this.INN = ("".equals(value)) ? "ИНН не указан" : value;
    }
 
//# agent.setBGCRM_ID(BGCRM_id);
    public String getBGCRM_ID() {
        return this.BGCRM_id;
    }
 
    public void setBGCRM_ID(String value) {
        this.BGCRM_id = ("".equals(value)) ? "Контрагент не указан" : value;
    }
}
