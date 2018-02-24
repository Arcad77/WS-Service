/*
**
** Теперь нужен клиент который работая автономно по команде:
** типа java -jar chatbot.jar
** но скорее понадобится wsimport
** wsimport.exe -Xnocompile -p ru.test.telegram.api.telegramservice -d 
**		c:\Users\SinTeZ\IdeaProjects\TelegramBot\src\main\java 
**		https://127.0.0.1/bgbilling/api/ru.test.bgbilling.telegram/TelegramService?wsdl
** явно понадобится bash файлик для init.d
** 
** Сам клиент-пример берет данные отправляет запрос и получив ответ от wsServer и просто их печатает на консоль
** Дальнейшие доработки делайте сами или заказывайте у соавторов нашего проекта!
**
*/
  
/**
***
*** Нашел класный пример! Как раз наш вариант, но надо теперь сделать переделку чтобы было видно что куда тянется.
*** Статья вот отсюда: http://dev-blogs.com/web-service-jax-ws/
***
**/
  
package uz.vtvs;

//import com.service.impl.PrintFigureService;
//import com.service.impl.PrintFigureImplService;
import uz.vtvs.bgb_1c.Agent1C;
import uz.vtvs.bgb_1c.ContractList;
import uz.vtvs.bgb_1c.ContractList_Service;
import uz.vtvs.bgb_1c.GetAgentList;

import java.util.List;
import java.util.ArrayList;

public class Client {
    public static void main(String [] args) {
//      PrintFigureImplService figureService = new PrintFigureImplService();
        ContractList_Service contractList = new ContractList_Service();
//      PrintFigureService service = figureService.getPrintFigureImplPort();
        ContractList service = contractList.getContractListPort();
        GetAgentList arguments = new GetAgentList();
        try {
            arguments.setFc("1");
            arguments.setFormatFIO("Full");
            System.out.println(service.getAgentList(arguments));
        } catch (NumberFormatException exc) {
            exc.printStackTrace();
        }
    }
}
