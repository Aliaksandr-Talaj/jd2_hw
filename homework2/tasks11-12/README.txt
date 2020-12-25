Делаю копию проекта
$ git status
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        ./

nothing added to commit but untracked files present (use "git add" to track)

Выставляю созданные файлы на stage:

$ git add .
warning: LF will be replaced by CRLF in task11/projectCopy/target/maven-status/maven-compiler-plugin/compile/default-compile/createdFiles.lst.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in task11/projectCopy/target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst.
The file will have its original line endings in your working directory

$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   README.txt
        new file:   projectCopy/pom.xml
        new file:   projectCopy/src/main/java/it/academy/servlet/TimeServlet.java
        new file:   projectCopy/src/main/webapp/WEB-INF/web.xml
        new file:   projectCopy/target/classes/it/academy/servlet/TimeServlet.class
        new file:   projectCopy/target/maven-archiver/pom.properties
        new file:   projectCopy/target/maven-status/maven-compiler-plugin/compile/default-compile/createdFiles.lst
        new file:   projectCopy/target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst
        new file:   projectCopy/target/maven-status/maven-compiler-plugin/testCompile/default-testCompile/inputFiles.lst
        new file:   projectCopy/target/task8-1.0-SNAPSHOT.war
        new file:   projectCopy/target/task8-1.0-SNAPSHOT/WEB-INF/classes/it/academy/servlet/TimeServlet.class
        new file:   projectCopy/target/task8-1.0-SNAPSHOT/WEB-INF/web.xml
        new file:   projectCopy/task8.iml


Делаю commit в бранч master:
		
$ git commit -m "Made a copy of project"
[master 8ca7af7] Made a copy of project
 13 files changed, 123 insertions(+)
 create mode 100644 task11/README.txt
 create mode 100644 task11/projectCopy/pom.xml
 create mode 100644 task11/projectCopy/src/main/java/it/academy/servlet/TimeServlet.java
 create mode 100644 task11/projectCopy/src/main/webapp/WEB-INF/web.xml
 create mode 100644 task11/projectCopy/target/classes/it/academy/servlet/TimeServlet.class
 create mode 100644 task11/projectCopy/target/maven-archiver/pom.properties
 create mode 100644 task11/projectCopy/target/maven-status/maven-compiler-plugin/compile/default-compile/createdFiles.lst
 create mode 100644 task11/projectCopy/target/maven-status/maven-compiler-plugin/compile/default-compile/inputFiles.lst
 create mode 100644 task11/projectCopy/target/maven-status/maven-compiler-plugin/testCompile/default-testCompile/inputFiles.lst
 create mode 100644 task11/projectCopy/target/task8-1.0-SNAPSHOT.war
 create mode 100644 task11/projectCopy/target/task8-1.0-SNAPSHOT/WEB-INF/classes/it/academy/servlet/TimeServlet.class
 create mode 100644 task11/projectCopy/target/task8-1.0-SNAPSHOT/WEB-INF/web.xml
 create mode 100644 task11/projectCopy/task8.iml

 $ git log
commit 8ca7af768d4a750665b84979752ac3c61c527d09 (HEAD -> master)
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:14:18 2020 +0300

    Made a copy of project

commit 151c54058aa3c568d9c69541e45e5b069f811643
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:05:42 2020 +0300

    Added homework2, tasks 8-9

Изменяю pom-файл, проверяю статус:
$ git status
On branch little
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   projectCopy/pom.xml

no changes added to commit (use "git add" and/or "git commit -a")

Фиксирую изменения в ветке little:
$ git add  projectCopy/pom.xml
$ git commit -m "Modified pom.xml"
[little 64075a7] Modified pom.xml
 1 file changed, 2 insertions(+), 2 deletions(-)


Перехожу на ветку master, изменяю файлы pom.xml и web.xml,
$ git checkout master
Switched to branch 'master'

При этом в файле, после перехода, нет видно изменений,
зафиксированных в другой ветке.
Смотрю статус после изменения файлов:
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   projectCopy/pom.xml
        modified:   projectCopy/src/main/webapp/WEB-INF/web.xml

no changes added to commit (use "git add" and/or "git commit -a")

Фиксирую изменения:
$ git add .
$ git commit -m "Modified pom.xml and web.xml"
[master ebc9686] Modified pom.xml and web.xml
 2 files changed, 3 insertions(+), 2 deletions(-)

 Смотрю лог:
 
$ git log
commit ebc968681ad2291aec69d28d610dfed64ede1735 (HEAD -> master)
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:48:33 2020 +0300

    Modified pom.xml and web.xml

commit 8ca7af768d4a750665b84979752ac3c61c527d09
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:14:18 2020 +0300

    Made a copy of project

commit 151c54058aa3c568d9c69541e45e5b069f811643
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:05:42 2020 +0300

    Added homework2, tasks 8-9

Смотрю лог соседней ветки:
$ git checkout little
Switched to branch 'little'
$ git log
commit 64075a75db64a91d7870b2152f0c1e78503a65a2 (HEAD -> little)
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:46:01 2020 +0300

    Modified pom.xml

commit 8ca7af768d4a750665b84979752ac3c61c527d09
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:14:18 2020 +0300

    Made a copy of project

commit 151c54058aa3c568d9c69541e45e5b069f811643
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:05:42 2020 +0300

    Added homework2, tasks 8-9

Перехожу на ветку master  и начинаю слияние:
$ git checkout master
Switched to branch 'master'
$ git merge little
Auto-merging task11/projectCopy/pom.xml
CONFLICT (content): Merge conflict in task11/projectCopy/pom.xml
Automatic merge failed; fix conflicts and then commit the result.

Редактирую файл, в котором присутствует следующий фрагмент:
	

<<<<<<< HEAD
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
=======
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
>>>>>>> little

Вношу необходимые изменения и фиксирую:
$ git add projectCopy/pom.xml
$ git commit -m "Merged branches"
[master bfe3636] Merged branches

Проверяю лог:
$ git log
commit bfe36362f9b3786416ab514db6e9a3ea3337e138 (HEAD -> master)
Merge: ebc9686 64075a7
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:59:22 2020 +0300

    Merged branches

commit ebc968681ad2291aec69d28d610dfed64ede1735
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:48:33 2020 +0300

    Modified pom.xml and web.xml

commit 64075a75db64a91d7870b2152f0c1e78503a65a2 (little)
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:46:01 2020 +0300

    Modified pom.xml

commit 8ca7af768d4a750665b84979752ac3c61c527d09
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:14:18 2020 +0300

    Made a copy of project

commit 151c54058aa3c568d9c69541e45e5b069f811643
Author: Aliaksandr <aliaksandr.talaj@gmail.com>
Date:   Fri Dec 25 06:05:42 2020 +0300

    Added homework2, tasks 8-9
