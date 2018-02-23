package

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
  
package com.client;

//import com.service.impl.PrintFigureService;
//import com.service.impl.PrintFigureImplService;
import api.uz.vtvs.bgbilling.service.impl.ContractListImplService;
import api.uz.vtvs.bgbilling.service.impl.ContractListService;
import java.util.List;
import java.util.ArrayList;

public class Client {
    public static void main(String [] args) {
//      PrintFigureImplService figureService = new PrintFigureImplService();
        ContractListImplService contractList = new ContractListImplService();
//      PrintFigureService service = figureService.getPrintFigureImplPort();
        ContractListService service = contractList.getContractListImplPort();
        List<Integer> arguments = new ArrayList<Integer>();
        try {
            arguments.add(Integer.parseInt(args[1]));
            arguments.add(Integer.parseInt(args[2]));
            System.out.println(service.showInfo(args[0], arguments));
        } catch (NumberFormatException exc) {
            exc.printStackTrace();
        }
    }
}
