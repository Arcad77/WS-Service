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
