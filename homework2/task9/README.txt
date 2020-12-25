Для переустановки приложения выполняю
$ mvn tomcat:redeploy
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------------< homework2:task8 >---------------------------
[INFO] Building task8 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] >>> tomcat-maven-plugin:1.1:redeploy (default-cli) > package @ task8 >>>
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
[INFO] Webapp assembled in [49 msecs]
[INFO] Building war: D:\jd2_hw\homework2\task8\target\task8-1.0-SNAPSHOT.war
[INFO] WEB-INF\web.xml already added, skipping
[INFO]
[INFO] <<< tomcat-maven-plugin:1.1:redeploy (default-cli) < package @ task8 <<<
[INFO]
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:redeploy (default-cli) @ task8 ---
[INFO] Deploying war to http://localhost:8080/task8
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.261 s
[INFO] Finished at: 2020-12-25T04:42:42+03:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.codehaus.mojo:tomcat-maven-plugin:1.1:redeploy (default-cli) on project task8: Cannot invoke Tomcat manager: Server returned HTTP response code: 405 for URL: http://localhost:8080/manager/deploy?path=%2Ftask8&war=&update=true -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException

Добавляю плагин в pom.xml:

<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>tomcat-maven-plugin</artifactId>
    <version>1.1</version>
    <configuration>
        <url>http://localhost:8080/manager/text</url>
        <username>tomcat</username>
        <password>tomcat</password>
    </configuration>
 </plugin>
 
 Повторяю попытку переустановки:
 $ mvn tomcat:redeploy
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------------< homework2:task8 >---------------------------
[INFO] Building task8 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] >>> tomcat-maven-plugin:1.1:redeploy (default-cli) > package @ task8 >>>
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
[INFO] Webapp assembled in [47 msecs]
[INFO] Building war: D:\jd2_hw\homework2\task8\target\task8-1.0-SNAPSHOT.war
[INFO] WEB-INF\web.xml already added, skipping
[INFO]
[INFO] <<< tomcat-maven-plugin:1.1:redeploy (default-cli) < package @ task8 <<<
[INFO]
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:redeploy (default-cli) @ task8 ---
[INFO] Deploying war to http://localhost:8080/task8
[INFO] OK - ---------- ------- --------- - ----------- ---- [/task8]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.103 s
[INFO] Finished at: 2020-12-25T04:56:59+03:00
[INFO] ------------------------------------------------------------------------

Информация о сервере:
$ mvn tomcat:sessions
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------------< homework2:task8 >---------------------------
[INFO] Building task8 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:sessions (default-cli) @ task8 ---
[INFO] Listing session information for application at http://localhost:8080/task8
[INFO] OK - ---------- - ------- ---------- -- ---- --------- [/task8]
[INFO] ----------- ------------ ------ ----------- ------: [30] -----
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.189 s
[INFO] Finished at: 2020-12-25T05:05:23+03:00
[INFO] ------------------------------------------------------------------------

$ mvn tomcat:list
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------------< homework2:task8 >---------------------------
[INFO] Building task8 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:list (default-cli) @ task8 ---
[INFO] Listing applications at http://localhost:8080/manager/text
[INFO] OK - ------ ---------- --- ------------ ----- [localhost]
[INFO] /:running:0:ROOT
[INFO] /task8:running:0:task8
[INFO] /tomcat-quickstart-1.0-SNAPSHOT:stopped:0:tomcat-quickstart-1.0-SNAPSHOT
[INFO] /examples:running:0:examples
[INFO] /host-manager:running:0:host-manager
[INFO] /manager:running:0:manager
[INFO] /docs:running:0:docs
[INFO] /tomcat-quickstart:stopped:0:tomcat-quickstart
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.152 s
[INFO] Finished at: 2020-12-25T05:05:58+03:00
[INFO] ------------------------------------------------------------------------

$ mvn tomcat:info
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------------< homework2:task8 >---------------------------
[INFO] Building task8 1.0-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- tomcat-maven-plugin:1.1:info (default-cli) @ task8 ---
[INFO] Listing server information at http://localhost:8080/manager/text
[INFO] OK - Server info
[INFO] Tomcat Version: [Apache Tomcat/9.0.41]
[INFO] OS Name: [Windows 7]
[INFO] OS Version: [6.1]
[INFO] OS Architecture: [amd64]
[INFO] JVM Version: [11+28]
[INFO] JVM Vendor: [Oracle Corporation]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.189 s
[INFO] Finished at: 2020-12-25T05:13:28+03:00
[INFO] ------------------------------------------------------------------------

 