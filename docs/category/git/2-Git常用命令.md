# Git常用命令

![img](2-Git%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4.assets/011500266295799.jpg)

```bat
git init                                                  # 初始化本地git仓库（创建新仓库）
git config --global user.name "xxx"                       # 配置用户名
git config --global user.email "xxx@xxx.com"              # 配置邮件
git config --global color.ui true                         # git status等命令自动着色
git config --global color.status auto
git config --global color.diff auto
git config --global color.branch auto
git config --global color.interactive auto
git config --global --unset http.proxy                    # remove  proxy configuration on git
git clone git+ssh://git@192.168.53.168/VT.git             # clone远程仓库
git clone <url>   name 					 				  # name克隆到文件目录下
git status                                                # 查看当前版本状态（是否修改）
git add *.c												  # 添加.c后缀名结尾的所有文件
git add xyz                                               # 添加xyz文件至index
git add .                                                 # 增加当前子目录下所有更改过的文件至index
git commit -m 'xxx'                                       # 提交
git commit --amend -m 'xxx'                               # 合并上一次提交（用于反复修改）
git commit -am 'xxx'                                      # 将add和commit合为一步
git rm xxx                                                # 删除index中的文件
git rm -r *                                               # 递归删除
git log                                                   # 显示提交日志
git log -1                                                # 显示1行日志 -n为n行
git log -5
git log --stat                                            # 显示提交日志及相关变动文件
git log -p -m
git show dfb02e6e4f2f7b573337763e5c0013802e392818         # 显示某个提交的详细内容
git show dfb02                                            # 可只用commitid的前几位
git show HEAD                                             # 显示HEAD提交日志
git show HEAD^                                            # 显示HEAD的父（上一个版本）的提交日志 ^^为上两个版本 ^5为上5个版本
git tag                                                   # 显示已存在的tag
git tag -a v2.0 -m 'xxx'                                  # 增加v2.0的tag
git show v2.0                                             # 显示v2.0的日志及详细内容
git log v2.0                                              # 显示v2.0的日志
git diff                                                  # 显示所有未添加至index的变更
git diff --cached                                         # 显示所有已添加index但还未commit的变更
git diff HEAD^                                            # 比较与上一个版本的差异
git diff HEAD -- ./lib                                    # 比较与HEAD版本lib目录的差异
git diff origin/master..master                            # 比较远程分支master上有本地分支master上没有的
git diff origin/master..master --stat                     # 只显示差异的文件，不显示具体内容
git remote add origin git+ssh://git@192.168.53.168/VT.git # 增加远程定义（用于push/pull/fetch）
git branch                                                # 显示本地分支
git branch --contains 50089                               # 显示包含提交50089的分支
git branch -a                                             # 显示所有分支
git branch -r                                             # 显示所有原创分支
git branch --merged                                       # 显示所有已合并到当前分支的分支
git branch --no-merged                                    # 显示所有未合并到当前分支的分支
git branch -m master master_copy                          # 本地分支改名
git checkout -b master_copy                               # 从当前分支创建新分支master_copy并检出
git checkout -b master master_copy                        # 上面的完整版
git checkout features/performance                         # 检出已存在的features/performance分支
git checkout --track hotfixes/BJVEP933                    # 检出远程分支hotfixes/BJVEP933并创建本地跟踪分支
git checkout v2.0                                         # 检出版本v2.0
git checkout -b devel origin/develop                      # 从远程分支develop创建新本地分支devel并检出
git checkout -- README                                    # 检出head版本的README文件（可用于修改错误回退）
git merge origin/master                                   # 合并远程master分支至当前分支
git cherry-pick ff44785404a8e                             # 合并提交ff44785404a8e的修改
git push origin master                                    # 将当前分支push到远程master分支
git push origin :hotfixes/BJVEP933                        # 删除远程仓库的hotfixes/BJVEP933分支
git push --tags                                           # 把所有tag推送到远程仓库
git fetch                                                 # 获取所有远程分支（不更新本地分支，另需merge）
git fetch --prune                                         # 获取所有原创分支并清除服务器上已删掉的分支
git pull origin master                                    # 获取远程分支master并merge到当前分支
git mv README README2                                     # 重命名文件README为README2
git reset --hard HEAD                                     # 将当前版本重置为HEAD（通常用于merge失败回退）
git rebase
git branch -d hotfixes/BJVEP933                           # 删除分支hotfixes/BJVEP933（本分支修改已合并到其他分支）
git branch -D hotfixes/BJVEP933                           # 强制删除分支hotfixes/BJVEP933
git ls-files                                              # 列出git index包含的文件
git show-branch                                           # 图示当前分支历史
git show-branch --all                                     # 图示所有分支历史
git whatchanged                                           # 显示提交历史对应的文件修改
git revert dfb02e6e4f2f7b573337763e5c0013802e392818       # 撤销提交dfb02e6e4f2f7b573337763e5c0013802e392818
git ls-tree HEAD                                          # 内部命令：显示某个git对象
git rev-parse v2.0                                        # 内部命令：显示某个ref对于的SHA1 HASH
git reflog                                                # 显示所有提交，包括孤立节点
git show HEAD@{5}
git show master@{yesterday}                               # 显示master分支昨天的状态
git log --pretty=format:'%h %s' --graph                   # 图示提交日志
git show HEAD~3
git show -s --pretty=raw 2be7fcb476
git stash                                                 # 暂存当前修改，将所有至为HEAD状态
git stash list                                            # 查看所有暂存
git stash show -p stash@{0}                               # 参考第一次暂存
git stash apply stash@{0}                                 # 应用第一次暂存
git grep "delete from"                                    # 文件中搜索文本“delete from”
git grep -e '#define' --and -e SORT_DIRENT
git gc
git fsck
GitHub 的提示，在本地的仓库下运行命令
$ mkdir runoob-git-test                     # 创建测试目录
$ cd runoob-git-test/                       # 进入测试目录
$ echo "# 菜鸟教程 Git 测试" >> README.md     # 创建 README.md 文件并写入内容
$ ls                                        # 查看目录下的文件
README
$ git init                                  # 初始化
$ git add README.md                         # 添加文件
$ git commit -m "添加 README.md 文件"        # 提交并备注信息
[master (root-commit) 0205aab] 添加 README.md 文件
 1 file changed, 1 insertion(+)
 create mode 100644 README.md

# 提交到 Github
$ git push --set-upstream origin master 	# 提交到设置的上游分支
$ git remote add origin git@github.com:tianqixin/runoob-git-test.git
$ git push -u origin master

```

## 命令行上创建新存储库

> echo "# JavaLearningLog" >> README.md

这行命令会在`README.md`文件的末尾添加`# JavaLearningLog`。如果`README.md`文件不存在，则会创建一个新的文件。

> git init

初始化一个新的Git仓库在当前目录。

> git add README.md

将`README.md`文件添加到Git仓库中，准备进行提交。

> git commit -m "first commit"

提交更改，并附带消息“first commit”。

> git branch -M main

确保当前分支是主分支（main）。

> git remote add origin git@github.com:anuouan/JavaLearningLog.git

添加一个名为origin的远程仓库，链接到`anuouan/JavaLearningLog.git`。这通常用于将本地仓库与远程仓库关联。

> git push -u origin main

将本地主分支推送到远程仓库origin。`-u`参数表示“setUpstream”，它将设置本地主分支跟踪远程主分支。



## 命令行推送现有存储库

> git remote add origin git@github.com:anuouan/JavaLearningLog.git

* 这行代码是在本地Git仓库中添加一个远程仓库的引用，并命名为"origin"。
* git@github.com:anuouan/JavaLearningLog.git 是远程仓库的地址，其中anuouan是GitHub上的用户名，JavaLearningLog是该用户下的一个仓库名称。
* 添加完远程仓库后，你可以使用git push命令将本地的更改推送到这个远程仓库。

> git branch -M main

- 这行代码将当前所在的分支重命名为"main"。在早期的Git版本中，默认的主分支是`master`，但在后续版本中，为了更好地支持其他命名约定，Git推荐使用`main`作为主分支的名称。
- `-M`选项确保如果本地已经有一个名为"main"的分支，它会重命名现有的分支而不是创建一个新的。

> git push -u origin main

- 这行代码将本地的"main"分支推送到前面添加的远程仓库"origin"。

- `-u`或`--set-upstream`选项表示设置上游（upstream），这样当你运行`git pull`或`git push`时，Git会知道应该与哪个远程分支进行交互。
- 这条命令实际上执行了两个主要操作：首先，它将本地的"main"分支推送到远程仓库；其次，它设置"main"分支为跟踪远程的"main"分支，这样在未来进行拉取（pull）或推送（push）操作时，Git会知道应该与哪个远程分支交互。
