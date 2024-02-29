# Git

## 1. Git安装

### 1.1. 概述

Git是一个开源的分布式版本控制系统，可以有效、高速的处理从很小到非常大的项目版本管理，是目前使用范围最广的版本管理工具。

### 1.2. 下载安装

下载地址：https://git-scm.com/

*下载后傻瓜式一键安装，建议安装在英文目录下*

安装完成后在开始菜单中能够找到如下程序

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191188009-52.png)

或者右击桌面，能够看到如下Git选项

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187935-1.png)

- GUI为用户界面模式

- Bash为命令行模式

### 1.3. 系统配置

由于git是分布式管理工具，需要输入用户名和邮箱以作为标识，因此，我们按右键打开`Git Bash`命令框

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187935-2.png)

在命令行输入下列的命令：

```bash
git config --global user.name "用户名"
git config --global user.email "邮箱"
// “用户名” 可以为中文，“邮箱” 建议使用qq邮箱，方便记忆
```

生成SSH公钥，许多 Git 服务器都使用 SSH 公钥进行认证，所以我们也需要配置该公钥

```bash
 // 输入如下命令，三次回车即可生成 ssh key
 ssh-keygen -t rsa -C "邮箱"
```

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187936-3.png)

### 1.4. 常用命令

| 命令                 | 备注                                                         |
| -------------------- | ------------------------------------------------------------ |
| git status           | 查看仓库的改变情况，会有相关的提示操作出现                   |
| git add              | 直接添加所有改动的文件                                       |
| git commit -m "note" | 确认生成本地的版本，note是 版本特点说明                      |
| git push             | 将改动上传到github，若没有指定分支，则需要使用git push origin master |
| git log              | 查看版本更新情况                                             |
| git reset -hard x    | 回退到某个本地版本,x为git log中出现的hash值的前七位          |
| git clean -xf        | 清除所有的未提交文件                                         |

### 1.5. Git基本操作

- 创建一个目录

- ```bash
  mkdir 文件名
  mkdir 文件名/子文件名
  ```

-  进入一个目录

- ```bash
  cd 文件名/
  ```

- 查看当前所在磁盘的位置

- ```bash
  pwd
  ```

- 初始化仓库

- ```bash
  git init
  ```

### 1.6. GUI可视化工具安装

- 下载地址：https://download.tortoisegit.org/tgit/2.8.0.0/，建议采用迅雷下载

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187936-4.png)

- 默认下一步安装（最新版本目前为2.8）

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187936-5.png)

- 安装完成后，右击桌面，弹出如下框即表示安装完成

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187936-6.png)

- 也可以找到有版本控制的文件，右击查看，如下图

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187936-7.png)

- 汉化包安装

尽量建议采用英文的GUI操作，如果你坚持要采用中文版本，那么可以下载语言汉化包

汉化包版本一定要和`TortoiseGit`版本一致，否则汉化

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187936-8.png)

### 1.7. GIT区域介绍

1. git有3个区域
   1. 工作区（`working directory`）：项目的根目录，不包括.git在内的其他文件
   2. 暂存区（`stage area`）：是一个看不见的区域，
      -   `git add`命令就是将文件添加到该区域，
      -   `git status`命令可以查看当前暂存区的文件
   3. 本地仓库（`repository`）：指在工作目录下创建的一个.git目录，这是一个隐藏目录。
      -   `git commit -m "日志"`名可以将暂存区的代码提交到本地仓库。
      -   `git push -u origin master`就是将本地仓库的代码推送到远程仓库
2. git文件的3种状态
   1. 已修改（modified），存在于工作区，文件修改后的状态
   2. 已暂存（staged），存在于暂存区，采用`git add`命令后的状态
   3. 已提交（committed），存在于本地仓库，采用`git commit`命令后的状态

## 2. 码云+Git配置仓库

- 为什么要这么做？
  -  若需要将本地仓库的代码同步更新到远程托管服务器，则需要与远程服务器建立通信授权连接，最常见的就是利用上述所生成的ssh key进行配置。

​     常见的托管平台有GitHub，GitLab（开源），码云，企业中也用该产品搭建企业的代码管理平台。

- 前置条件
  - 本地git已安装并配置了Git用户参数，本地已生成了SSH Key
  - 注册码云平台账号，建议采用QQ邮箱进行注册，方便记忆和密码找回
- 秘钥配置
  - 注册好码云后，进入设置中心，再点击SSH公钥

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187940-9.png)

- 在本机磁盘目录中，找到当前用户下的.ssh目录，并编辑其中的.pub结尾的文件

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187940-10.png)

- 将内容拷贝至码云中，拷贝后，标题能够自动识别，也可以自行修改

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-11.png)

- 打开Git Bash终端输入如下命令进行连接测试

```Java
ssh -T git@gitee.com
```

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-12.png)

- 使用命令同步代码
  - 代码同步有3个步骤：add、commit、push

1、在本地磁盘中找一个目录，用于初始化本地仓库存放项目代码

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-13.png)

2、将项目拷贝到该目录下，与.git同级（项目不能为空文件夹）

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-14.png)

3、使用名，将hospital-parent添加到本地仓库中，使用`git add 目录`命令

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-15.png)

4、将项目提交至本地仓库，使用`git commit -m 备注`命令

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-16.png)

5、在码云上创建一个仓库壳子，用来存放待上传的项目

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-17.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-18.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-19.png)

**注意：上述所复制的链接就是项目所在的仓库地址（我们使用SSH命令进行交互操作）**

6、将本地库与远程库关联

关联命令：`git remote add origin 链接`

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187941-20.png)

7、远程仓库与本地仓库合并

这时候不着急推，先将远程仓库的文件同步一次到本地，否则直接推会报错

```bash
 // 表示从远程master分支拉取代码与本地仓库进行合并，此时一定要保证本地的文件是绿色的
 git pull --rebase origin master
```

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-21.png)

此时你会发现本地代码多了几个文件

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-22.png)

8、将本地代码推送到远程分支

- 命令

```bash
 // push表示推送到远程分支
 git push -u origin master
```

- 执行实例

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-23.png)

- 效果实例

 刷新码云的远程仓库，能够看到如下结构

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-24.png)

9、后续代码改动

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-25.png)

依次执行以下命令（远程仓库没有发生改动的情况），如果远程分支的代码已经被别人修改，需要先拉取代码，再提交，这个过程稍微复杂一点，若存在冲突则涉及到同一行代码的合并

- 执行add

```bash
// 将已改动的文件添加到暂存区
 git add hospital-parent/
```

- 执行commit

```bash
// 将暂存区的代码提交到本地仓库
 git commit -m "第二次提交"  
```

- 执行push

```bash
 // 将本地仓库的所有更改推送到远程服务器的master分支
 git push origin master //（完整写法，远程分支若不存在则会被创建）
 //或者
 git push origin //（远程仓库与本地仓库存在分支最终关系的写法）
 //或者
 git push//（远程仓库只有一个分支，最简单的写法）     
```

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-26.png)

10、使用工具同步代码

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-27.png)

如果修改代码后直接提交可以采用`Git Commit -> "master"`，该操作中可以直接push

如果需要拉取远程分支上的代码，则可以点击`TortoiseGit -> Pull`

如果仅仅是推送代码到远程分支，则可以点击`TortoiseGit -> Push`

小乌龟push出现异常

```
 Disconnected：No supported authentication methods avaliable (server sent publickey)
```

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-28.png)

将小乌龟Network处的`C:\Program Files\TortoiseGit\bin\TortoiseGitPlink.exe`路径改为`C:\Program Files\Git\usr\bin\ssh.exe`即可

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-29.png)

## 3. IDEA+Git

1. 在IDEA中设置Git，在`File`-->`Setting`-->`Version Control`-->`Git`-->`Path to Git executable`选择你的git安装后的git.exe文件，然后点击Test，测试是否设置成功

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-30.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-31.png)

2. 配置码云（gitee）

   1. 插件安装

      由于IDEA没有直接码云，所以需要选择安装Gitee插件，找到Plugins，搜索Gitee，安装后重启

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-32.png)

​	2. 登录信息配置

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-33.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-34.png)

​	3. 直接将本项目同步至码云（新建仓库）

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-35.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-36.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-37.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187942-38.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-39.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-40.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-41.png)

2. 代码提交或更新

3. 如果文件发生改动，我们可以采用3种方式进行同步更新

- Git Bash命令
- 小乌龟客户端工具
- IDEA直接同步



4. 这里我直接说IDEA的操作，下面中的蓝色文件已经被修改了，颜色不太一样，红色文件表示是没有版本控制的

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-42.png)



5. 在项目根目录上右击，选择`Git->Commit Directory`进行提交

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-43.png)

6. 提交操作界面，需要你勾选文件，填写日志，并提示了差异对比

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-44.png)



7. 点击Commit按钮后出现了如下警告信息，不用担心，你可以直接Commit，也可以回去查看源代码中是否有警告提示，消除对应的警告即可

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-45.png)



8. 点击上图的Review之后，控制台提示了警告位置

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-46.png)



9. 你可以置之不理，继续commit，也可以加以改正，改正如下

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-47.png)



10. 选择Commit提交后的提示，但此时我们并没有push

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-48.png)

10.  我们可以找出现在可以push到远程分支的commit，如下操作

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-49.png)

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-50.png)



11. 推送后查看码云是否已经更新，如下图

![img](1-git%E8%87%AA%E5%AD%A6%E6%95%99%E7%A8%8B.assets/1709191187943-51.png)

12. 总结

IDEA操作码云和使用工具或命令的原理差不多，均需要add，commit，push等操作，更新则采用pull，如果涉及到多人协同开发时，还会遇到更加复杂的操作，当工具内部无法处理这些功能的时候，我们可以借助系统中的小乌龟来完成

## 4. 企业团队协作

我们知道git除了我们个人记录代码外，更多的是在工作中使用。在前面掌握最基础的操作后，接下来我们进入协作实战部分，每个公司都有自己的git协作流程，不同开发工具也有不同的git使用方式。由于Git提供的操作指令集非常庞大，但团队常规能使用到的可能也就30%左右，接下来的内容也就围绕这30%展开。

- 企业使用的Git服务：自建`Gitlab、Codeup、Gitee`
- 个人使用的Git服务：`Gitee、GitHub`
- Git区域回顾
  - Git按照大的分类分为3个区域，分别为：工作区、暂存区、Git仓库
  - 按照细分为5个区域，分别为：工作区、缓存区、贮存区、本地仓库、远程仓库

### 4.1. 分支操作branch

1. 本地分支、远程分支branch
2. checkout

### 4.2. 协作流程git flow

1. git flow：公司自定义的工作流程
2. merge request

### 4.3. 结合IDE操作

1. IDEA系列
2. VSCode系列
3. Eclipse系列

### 4.4. 持续集成**CI****、****CD**

1. jenkins构建
2. K8S云原生工作流，可以参考阿里云云效（codeup）

## 5. 附录

### 5.1. 新建代码库

```bash
 # 在当前目录新建一个Git代码库
 $ git init
 
 # 新建一个目录，将其初始化为Git代码库
 $ git init [project-name]
 
 # 下载一个项目和它的整个代码历史
 $ git clone [url]
```

### 5.2. 配置

Git 的设置文件为`.gitconfig`，它可以在用户主目录下（全局配置），也可以在项目目录下（项目配置）。

```bash
 # 显示当前的Git配置
 $ git config --list
 
 # 编辑Git配置文件
 $ git config -e [--global]
 
 # 设置提交代码时的用户信息
 $ git config [--global] user.name "[name]"
 $ git config [--global] user.email "[email address]"
```

### 5.3. 增加 / 删除文件

```bash
 # 添加指定文件到暂存区
 $ git add [file1] [file2] ...
 
 # 添加指定目录到暂存区，包括子目录
 $ git add [dir]
 
 # 添加当前目录的所有文件到暂存区
 $ git add .
 
 # 添加每个变化前，都会要求确认
 # 对于同一个文件的多处变化，可以实现分次提交
 $ git add -p
 
 # 删除工作区文件，并且将这次删除放入暂存区
 $ git rm [file1] [file2] ...
 
 # 停止追踪指定文件，但该文件会保留在工作区
 $ git rm --cached [file]
 
 # 改名文件，并且将这个改名放入暂存区
 $ git mv [file-original] [file-renamed]
```

### 5.4. 代码提交

```bash
 # 提交暂存区到仓库区
 $ git commit -m [message]
 
 # 提交暂存区的指定文件到仓库区
 $ git commit [file1] [file2] ... -m [message]
 
 # 提交工作区自上次commit之后的变化，直接到仓库区
 $ git commit -a
 
 # 提交时显示所有diff信息
 $ git commit -v
 
 # 使用一次新的commit，替代上一次提交
 # 如果代码没有任何新变化，则用来改写上一次commit的提交信息
 $ git commit --amend -m [message]
 
 # 重做上一次commit，并包括指定文件的新变化
 $ git commit --amend [file1] [file2] ...
```

### 5.5. 分支

```bash
 # 列出所有本地分支
 $ git branch
 
 # 列出所有远程分支
 $ git branch -r
 
 # 列出所有本地分支和远程分支
 $ git branch -a
 
 # 新建一个分支，但依然停留在当前分支
 $ git branch [branch-name]
 
 # 新建一个分支，并切换到该分支
 $ git checkout -b [branch]
 
 # 新建一个分支，指向指定commit
 $ git branch [branch] [commit]
 
 # 新建一个分支，与指定的远程分支建立追踪关系
 $ git branch --track [branch] [remote-branch]
 
 # 切换到指定分支，并更新工作区
 $ git checkout [branch-name]
 
 # 切换到上一个分支
 $ git checkout -
 
 # 建立追踪关系，在现有分支与指定的远程分支之间
 $ git branch --set-upstream [branch] [remote-branch]
 
 # 合并指定分支到当前分支
 $ git merge [branch]
 
 # 选择一个commit，合并进当前分支
 $ git cherry-pick [commit]
 
 # 删除分支
 $ git branch -d [branch-name]
 
 # 删除远程分支
 $ git push origin --delete [branch-name]
 $ git branch -dr [remote/branch]
```

### 5.6. 标签

```bash
 # 列出所有tag
 $ git tag
 
 # 新建一个tag在当前commit
 $ git tag [tag]
 
 # 新建一个tag在指定commit
 $ git tag [tag] [commit]
 
 # 删除本地tag
 $ git tag -d [tag]
 
 # 删除远程tag
 $ git push origin :refs/tags/[tagName]
 
 # 查看tag信息
 $ git show [tag]
 
 # 提交指定tag
 $ git push [remote] [tag]
 
 # 提交所有tag
 $ git push [remote] --tags
 
 # 新建一个分支，指向某个tag
 $ git checkout -b [branch] [tag]
```

### 5.7. 查看信息

```bash
 # 显示有变更的文件
 $ git status
 
 # 显示当前分支的版本历史
 $ git log
 
 # 显示commit历史，以及每次commit发生变更的文件
 $ git log --stat
 
 # 搜索提交历史，根据关键词
 $ git log -S [keyword]
 
 # 显示某个commit之后的所有变动，每个commit占据一行
 $ git log [tag] HEAD --pretty=format:%s
 
 # 显示某个commit之后的所有变动，其"提交说明"必须符合搜索条件
 $ git log [tag] HEAD --grep feature
 
 # 显示某个文件的版本历史，包括文件改名
 $ git log --follow [file]
 $ git whatchanged [file]
 
 # 显示指定文件相关的每一次diff
 $ git log -p [file]
 
 # 显示过去5次提交
 $ git log -5 --pretty --oneline
 
 # 显示所有提交过的用户，按提交次数排序
 $ git shortlog -sn
 
 # 显示指定文件是什么人在什么时间修改过
 $ git blame [file]
 
 # 显示暂存区和工作区的差异
 $ git diff
 
 # 显示暂存区和上一个commit的差异
 $ git diff --cached [file]
 
 # 显示工作区与当前分支最新commit之间的差异
 $ git diff HEAD
 
 # 显示两次提交之间的差异
 $ git diff [first-branch]...[second-branch]
 
 # 显示今天你写了多少行代码
 $ git diff --shortstat "@{0 day ago}"
 
 # 显示某次提交的元数据和内容变化
 $ git show [commit]
 
 # 显示某次提交发生变化的文件
 $ git show --name-only [commit]
 
 # 显示某次提交时，某个文件的内容
 $ git show [commit]:[filename]
 
 # 显示当前分支的最近几次提交
 $ git reflog
```

### 5.8. 远程同步

```bash
 # 下载远程仓库的所有变动
 $ git fetch [remote]
 
 # 显示所有远程仓库
 $ git remote -v
 
 # 显示某个远程仓库的信息
 $ git remote show [remote]
 
 # 增加一个新的远程仓库，并命名
 $ git remote add [shortname] [url]
 
 # 取回远程仓库的变化，并与本地分支合并
 $ git pull [remote] [branch]
 
 # 上传本地指定分支到远程仓库
 $ git push [remote] [branch]
 
 # 强行推送当前分支到远程仓库，即使有冲突
 $ git push [remote] --force
 
 # 推送所有分支到远程仓库
 $ git push [remote] --all
```

### 5.9. 撤销

```bash
 # 恢复暂存区的指定文件到工作区
 $ git checkout [file]
 
 # 恢复某个commit的指定文件到暂存区和工作区
 $ git checkout [commit] [file]
 
 # 恢复暂存区的所有文件到工作区
 $ git checkout .
 
 # 重置暂存区的指定文件，与上一次commit保持一致，但工作区不变
 $ git reset [file]
 
 # 重置暂存区与工作区，与上一次commit保持一致
 $ git reset --hard
 
 # 重置当前分支的指针为指定commit，同时重置暂存区，但工作区不变
 $ git reset [commit]
 
 # 重置当前分支的HEAD为指定commit，同时重置暂存区和工作区，与指定commit一致
 $ git reset --hard [commit]
 
 # 重置当前HEAD为指定commit，但保持暂存区和工作区不变
 $ git reset --keep [commit]
 
 # 新建一个commit，用来撤销指定commit
 # 后者的所有变化都将被前者抵消，并且应用到当前分支
 $ git revert [commit]
 
 # 暂时将未提交的变化移除，稍后再移入
 $ git stash
 $ git stash pop
```

### 5.10. 其他

```bash
 # 生成一个可供发布的压缩包
 $ git archive
```

### 相关链接

- http://www.ruanyifeng.com/blog/2015/12/git-cheat-sheet.html

> `注`：非原创，仅供自我学习，原创链接找不到了，如有介意联系我邮箱，谢谢
