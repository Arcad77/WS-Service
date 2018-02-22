# WS-Service

нужно 2 файла (это как минимум) - точнее наверное проекта
# первый проект - на стороне биллинга
это как минимум один фаил где описывается ws-сервис принимающий 3 параметра
@param_1 - строка @param_2 - целое @param_3 - дата
Сервис делает условно серьезные манипуляции к примеру
"SELECT c.id AS ID_contract, c.date1 AS From_Date, c.title AS Contract
	FROM contract AS c 
	LEFT JOIN contract_parameter_type_1 AS fam ON c.id = fam.cid AND fam.pid = 1 
  LEFT JOIN contract_parameter_type_1 AS inn ON c.id = inn.cid AND inn.pid = 14
	LEFT JOIN contract_parameter_type_2 AS adress ON c.id = adress.cid AND adress.pid = 4 
	WHERE c.fc = 0 
	AND fam.cid IS NOT NULL 
	AND c.date2 IS NULL"
И передает в ответ на запрос от клиента полученные результаты.
@ParamRes_ID_Contract, @ParamRes_From_Data @ParamRes_Contract @ParamRes_Fam @ParamRes_inn @ParamRes_adress

данный сервис в принципе готов и работает, его можно только улучшить!
и там 3 файла, 2 зачем написаны я знаю уже, зачем 3-й я не особо понял!

# Второй проект - сам клиент
Это также как минимум один файл где формируется некий сервис который работает демоном на томде или другом сервере
Он формирует запрос на биллинг (можно в случайном порядке), отправляет, получает, печатает куда-нибуть.

Исходя из опыта написания тут некоторые процедуры тоже надо вынести в 2-3 файла, для феншуя!

А уже в дальнейшем данную связку копировать и переименовывать для реализацыи других возникших задачь в будущем.
