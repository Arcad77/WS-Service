PATH_TO_PROJECT=`pwd`
 
# Удаляем каталог с предыдущим билдом
if test -d $PATH_TO_PROJECT/build;
then
    rm -rf $PATH_TO_PROJECT/build
fi
# Создаем новый каталог, куда будем помещать билд
mkdir $PATH_TO_PROJECT/build
 
# Удаляем каталог с классами веб сервисов
if test -d $PATH_TO_PROJECT/webservice;
then
    rm -rf $PATH_TO_PROJECT/webservice
fi
# Создаем новый каталог который будет содержать классы веб сервисов
mkdir $PATH_TO_PROJECT/webservice
# Вытяним с сервера классы, которые будут поддерживать взаимодействие
# приложение с веб сервисом
wsimport -d webservice -keep 	http://192.168.9.68:8181/bgbilling/api/ru.test.bgbilling.service/ContractList?wsdl
 
# Компилируем проект в каталог build
javac -d $PATH_TO_PROJECT/build -cp webservice src/*.java
 
# Запускаем приложение с запросом посчитать нам площадь
# круга с радиусом 35 (второй параметр для круга игнорируется)
java -cp webservice:build com.client.Client "CIRCLE" 35 83
