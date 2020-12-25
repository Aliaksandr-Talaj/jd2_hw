Вношу изменения в код сервлета, проверяю статус:
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   README.txt
        modified:   projectCopy/src/main/java/it/academy/servlet/TimeServlet.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        ../task12/

no changes added to commit (use "git add" and/or "git commit -a")

Ставлю на stage README.txt с комментариями к предыдущему заданию:
$ git add README.txt
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   README.txt

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   projectCopy/src/main/java/it/academy/servlet/TimeServlet.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        ../task12/

Отменяю изменения, внесённые в сервлет и проверяю результат:
$ git restore .
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   README.txt

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        ../task12/

Изменения сервлета отменены, при этом нужные изменения, с резултатами
выполнения предыдущего задания, остались.