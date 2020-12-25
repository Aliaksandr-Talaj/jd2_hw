Установку произвожу с помощью команды "mvn clean install"

$ mvn clean install
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------------< homework2:task8 >---------------------------
[INFO] Building task8 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ task8 ---
[INFO] Deleting D:\jd2_hw\homework2\task8\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ task8 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ task8 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to D:\jd2_hw\homework2\task8\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ task8 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ task8 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ task8 ---
[INFO]
[INFO] --- maven-war-plugin:2.2:war (default-war) @ task8 ---
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.thoughtworks.xstream.core.util.Fields (file:/d:/java/.m2/repository/com/thoughtworks/xstream/xstream/1.3.1/xstream-1.3.1.jar) to field java.util.Properties.defaults
WARNING: Please consider reporting this to the maintainers of com.thoughtworks.xstream.core.util.Fields
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[INFO] Packaging webapp
[INFO] Assembling webapp [task8] in [D:\jd2_hw\homework2\task8\target\task8-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Copying webapp resources [D:\jd2_hw\homework2\task8\src\main\webapp]
[INFO] Webapp assembled in [125 msecs]
[INFO] Building war: D:\jd2_hw\homework2\task8\target\task8-1.0-SNAPSHOT.war
[INFO] WEB-INF\web.xml already added, skipping
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ task8 ---
[INFO] Installing D:\jd2_hw\homework2\task8\target\task8-1.0-SNAPSHOT.war to d:\java\.m2\repository\homework2\task8\1.0-SNAPSHOT\task8-1.0-SNAPSHOT.war
[INFO] Installing D:\jd2_hw\homework2\task8\pom.xml to d:\java\.m2\repository\homework2\task8\1.0-SNAPSHOT\task8-1.0-SNAPSHOT.pom
[INFO]
[INFO] --- tomcat7-maven-plugin:2.2:undeploy (deployToTomcat) @ task8 ---
[INFO] Undeploying application at http://localhost:8080/task8
[INFO] OK - Удалено приложение по пути контекста [/task8]
[INFO]
[INFO] >>> tomcat7-maven-plugin:2.2:deploy (deployToTomcat) > package @ task8 >>>
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ task8 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ task8 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ task8 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ task8 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ task8 ---
[INFO] Skipping execution of surefire because it has already been run for this configuration
[INFO]
[INFO] --- maven-war-plugin:2.2:war (default-war) @ task8 ---
[INFO] Packaging webapp
[INFO] Assembling webapp [task8] in [D:\jd2_hw\homework2\task8\target\task8-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Copying webapp resources [D:\jd2_hw\homework2\task8\src\main\webapp]
[INFO] Webapp assembled in [49 msecs]
[INFO] Building war: D:\jd2_hw\homework2\task8\target\task8-1.0-SNAPSHOT.war
[INFO] WEB-INF\web.xml already added, skipping
[INFO]
[INFO] <<< tomcat7-maven-plugin:2.2:deploy (deployToTomcat) < package @ task8 <<<
[INFO]
[INFO]
[INFO] --- tomcat7-maven-plugin:2.2:deploy (deployToTomcat) @ task8 ---
[INFO] Deploying war to http://localhost:8080/task8
Uploading: http://localhost:8080/manager/text/deploy?path=%2Ftask8
Uploaded: http://localhost:8080/manager/text/deploy?path=%2Ftask8 (3734 KB at 8333.1 KB/sec)

[INFO] tomcatManager status code:200, ReasonPhrase:
[INFO] ОШ-?БКА - Приложение было развёрнуто в контекстном пути [/task8], но не стартовало
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.610 s
[INFO] Finished at: 2020-12-25T03:16:45+03:00
[INFO] ------------------------------------------------------------------------

На выходе "BUILD SUCCESS", однако имеет место ошибка
"[INFO] tomcatManager status code:200, ReasonPhrase:
[INFO] ОШ-?БКА - Приложение было развёрнуто в контекстном пути [/task8], но не стартовало"

При создании проекта использовал методику запуска сервлета с помощью аннотаций, по аналогии 
с классной работой. По факту столкнулся с ситуацией, когда Maven для установки проекта требует
наличия файла web.xml (хотя бы пустого), в противном случае установку не выполняет.
Именно поэтому данный файл присутствует в репозитории. 
При этом сервлет не запускается, т.к. ссылки на него в web.xml не определено, хотя сам файл присутствует.
Удаление вышеуказанного файла из папки webapps вручную решает данную проблему и
сервлет успешно запускается благодаря аннотации, выдавая на запрос 
http://localhost:8080/task8/time
"Now it is Fri Dec 25 03:59:10 AST 2020"
И это первый сервлет, который наконец заработал.
Вывод: при подобных проблемах с Maven и при отсутствии прямого доступа к файлам хоста, имеет смысл
отказаться от использования аннотаций @WebServlet в пользу web.xml. Вероятно вывод ошибочный, однако
на данный момент иной путь решения данной проблемы для меня не очевиден.

War-файл автоматически распаковывается сервером при запуске, т.к. в файле настроек сервера server.xml
по умолчанию присутствует параметр для хоста unpackWARs="true", чтоисключает необходимость в какой-либо
иной настройке контекста.