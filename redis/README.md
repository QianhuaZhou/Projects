# 黑马点评项目笔记

## 环境配置

#### 查看本机ip地址

```bash
(base) evelynzhou@Evelyns-MacBook-Pro-2 redis % ipconfig getifaddr en0

10.2.111.4
```

```bash
url: jdbc:mysql://your-mysql-host:3306/your_database?useSSL=false&serverTimezone=UTC
```
查询 MySQL 服务器的主机地址（your-mysql-host）：
127.0.0.1  好像是默认的(没搞懂怎么用命令行查询)

浏览区测试后端导入:
http://localhost:8081/shop-type/list

#### nginx启动

mac前端导入  
1.安装 nginx
2.使用brew info nginx查看 安装目录和配置文件的目录
3.把资料的nginx-1.18.0.2里的html文件夹直接覆盖到 nginx的安装目录的HTML文件
/opt/homebrew/Cellar/nginx/1.27.2/html
4.把资料的Nginx-1.18.0.2里的conf文件夹里的nginx-conf文件 覆盖 你安装的nginx的配置文件里的nginx-conf文件
/opt/homebrew/etc/nginx/nginx.conf
5.启动
启动nginx: brew services start nginx
若当前已启动,重启:sudo nginx -s reload

浏览区访问前端(手机模式):
http://localhost:8080/

配置完拦截器后:
http://localhost:8080/login.html

## 具体知识

**VO 和 PO、DTO、DO 的区别**

| 概念 | 全称                 | 作用                     | 主要特性                      |
| ---- | -------------------- | ------------------------ | ----------------------------- |
| VO   | Value Object         | 值对象，封装传输的数据   | 不可变、无唯一标识            |
| PO   | Persistent Object    | 持久化对象，对应数据库表 | 有唯一标识，直接与数据库交互  |
| DTO  | Data Transfer Object | 数据传输对象             | 用于前后端或服务间传输数据    |
| DO   | Domain Object        | 领域对象，封装业务逻辑   | 业务逻辑层使用，可能有唯一 ID |