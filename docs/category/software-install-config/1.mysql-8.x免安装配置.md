# mysql-8.x免安装配置

以mysql-8.0.32-winx64为例

1.下载压缩包后放在合适的目录下面

```Plain
Y:\Software\ProgramSoftware\mysql-8.0.32-winx64
```

![img](1-mysql-8.x%E5%85%8D%E5%AE%89%E8%A3%85%E9%85%8D%E7%BD%AE.assets/1709188648088-7.png)

2.配置环境变量

![img](1-mysql-8.x%E5%85%8D%E5%AE%89%E8%A3%85%E9%85%8D%E7%BD%AE.assets/1709188648081-1.png)

3.创建存储数据的文件夹并配置my.ini文件

![img](1-mysql-8.x%E5%85%8D%E5%AE%89%E8%A3%85%E9%85%8D%E7%BD%AE.assets/1709188648082-2.png)

用记事本打开my.ini文档，复制下面配置信息，按自己的需求进行修改，复制粘贴后保存退出

```YAML
[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=Y:\Software\ProgramSoftware\mysql-8.0.32-winx64   # 切记此处一定要用双斜杠\\，单斜杠我这里会出错，或者是用反单斜杠。自己尝试吧
# 设置mysql数据库的数据的存放目录
datadir=Y:\Software\ProgramSoftware\mysql-8.0.32-winx64\data   # 此处同上
# 允许最大连接数
max_connections=200
# 允许连接失败的次数。这是为了防止有人从该主机试图攻击数据库系统
max_connect_errors=10
# 服务端使用的字符集默认为UTF8
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
# 默认使用“mysql_native_password”插件认证
default_authentication_plugin=mysql_native_password
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8
[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8
```

4.系统左下角，Windows徽标

![img](1-mysql-8.x%E5%85%8D%E5%AE%89%E8%A3%85%E9%85%8D%E7%BD%AE.assets/1709188648082-3.png)

注意：这里必须是以“管理员身份”运行控制命令台！

5.安装配置MySQL服务

```YAML
#安装MySQL服务
mysqld --install mysql
#运行MySQL初始化命令
mysqld --initialize --console
#启动MySQL
net start mysql
#登录到MySQL服务
mysql -uroot -p
#修改密码
ALTER USER USER() IDENTIFIED BY '新密码';
```

![img](1-mysql-8.x%E5%85%8D%E5%AE%89%E8%A3%85%E9%85%8D%E7%BD%AE.assets/1709188648082-4.png)

![img](1-mysql-8.x%E5%85%8D%E5%AE%89%E8%A3%85%E9%85%8D%E7%BD%AE.assets/1709188648082-5.png)

6.重新开一个控制台登录是否登录成功！

![img](1-mysql-8.x%E5%85%8D%E5%AE%89%E8%A3%85%E9%85%8D%E7%BD%AE.assets/1709188648083-6.png)
