¬ношу изменени€ в код сервлета, провер€ю статус:
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

—тавлю на stage README.txt с комментари€ми к предыдущему заданию:
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

ќтмен€ю изменени€, внесЄнные в сервлет и провер€ю результат:
$ git restore .
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   README.txt

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        ../task12/

»зменени€ сервлета отменены, при этом нужные изменени€, с резултатами
выполнени€ предыдущего задани€, остались.