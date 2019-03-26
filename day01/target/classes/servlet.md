程祖红
邮箱: chengzh@tedu.cn
Servlet/JSP  ------------13天  内容多
代码:　代码并不是完整的程序　　　Ｔｏｍｃａｔ：在服务器代码的基础上加上一些东西  

学习方式
案例式的学习
学完之后, 归纳总结,变成知识体系

#day01
Hello World
b/s  架构


###什么是Servlet? (面试题)

Server: 服务器  let: 小程序
服务器端小程序

sun公司制定的一种用来扩展web服务器功能的组件规范

##(1)扩展web服务器功能
	web服务器只能够处理静态资源的请求(即, 需要事先将HTML文档图片等准备好),
	不能够处理动态资源的请求(即, 需要通过计算生成相应的html内容).
	所以我们需要让其具有处理动态资源的能力
	可以使用servlet来扩展web服务器的功能, 当web服务器收到请求, 如果该请求需要计算
	则将该请求交给servlet来处理. 
	
那么servlet是怎么扩展web服务器功能的呢

##(2)组件规范
1) 组件是什么?
	符合规范, 实现部分功能, 并且需要部署到相应的容器当中, 才能运行的软件模块 (比如:轮胎就属于组件,符合国标, 具有部分功能, 需要部署到容器(车)中)
	servlet就是一个组件, 需要部署到相应的servlet容器中才能运行.

2) 容器
	符合规范,提供组件运行环境的程序. (比如: 汽车, 符合国标)
	
![](servlet.png)

# 2.如何写一个Servlet?
	按照规范来写
step1. 写一个java类, 这个类要求实现一个接口(Servlet)||继承HttpServlet这个类
		通常是继承HttpServlet类.
step2. 编译.  把.java文件编译成.class字节码文件(
		通过javac命令来编译)
step3. 把编译好的字节码文件放到具有如下结构的文件中(打包变成一个组件)
		即: 创建一个具有如下结构的文件夹:
		    appname(应用名)
		    	WEB-INF
		    		classes(里面放.class字节码文件)
		    		lib(可以没有, 用于放jar包.jar文件)
		    		web.xml(部署描述文件: 文件中内容是servlet的类名,和怎么去访问它)
step4. 部署(把servlet部署到容器中Copy)
		将第三部创建好的整个文件夹copy但Servlet容器中
		注: 为了方便copy, 可以将第三部创建好的整个文件夹使用jar命令压缩成一个以.war为后缀的文件, 然后copy(容器会自动解压的)
step5. 启动servlet容器, 访问servlet
		访问规则:
			http://ip(容器的ip):port(端口号)/appname/url-pattern(访问地址)
			注: url-pattern在web.xml文件中定义.
			
HelloWord:
	http://localhost:8089/day01/hello     Hello  Kitty
	http://ip(容器的ip):port(端口号)/appname(工程项目名)/url-pattern


# 3. 安装Tomcat, 并进行简单的配置   雄性的猫
   注: Tomcat是apache开发的一款servlet的容器
		可以从  www.apache.org 网站下载
	D:/tts9/apache-tomcat-7.0.67
	
打开eclipse
	window --> perferences ---> server ----> 

javaEE: 企业版

继承HttpServlet
生成service方法: Resource--> override-->HttpServlet-->service(HttpServletRequest HttpServletResponse)

访问地址: http://localhost:8089/day01/hello
 

# 4. Servlet是如何运行的? (面试题 )
比如在浏览器地址栏输入 http://ip地址:port端口号/appname/hello

1. 浏览器会依据ip,port建立连接
2. 浏览器创建请求数据包, 并将请求数据包发送给容器
3. 容器解析请求数据包中的数据, 然后将解析到的数据放到请求对象中,
	然后再创建一个响应对象.
4. 容器会创建Servlet实例, 然后调用该实例的service方法.
	注: 容器会将请求对象和响应对象作为参数传入
	,开发人员可以通过请求对象获取请求数据包中的数据, 
	然后将处理结果写到响应对象中去即可.
	也就是说开发人员不用再关注网络相关的问题(比如解析请求数据包,生成响应数据包等等)
	注2: 容器只会创建一个Servlet实例
5. servlet容器从响应对象中获取处理结果. 然后生成响应数据包, 并发送给浏览器.
6. 浏览器解析响应数据包, 生成对应的页面.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      

# 5.常见的错误
## (1) 404
	404是一个状态码, 表示服务器依据请求地址找不到对应的资源.
	1)错误产生的原因
		a. 请求地址写错
			http://ip:port/appname/url-pattern
		b. 没有部署, 或者部署(copy)失败
			Project-->Clean -->重新部署
			
	
## (2) 500
	500也是一个状态码, 表示服务器端运行出错. (1.服务器出问题, 2.程序出问题)
	2)错误产生的原因
		a. 没有严格按照规范来写代码
		比如: 没有继承HttpServlet, 或者说部署描述文件中servlet-class类名写错等等.
		b. 代码不够严谨产生的异常
		比如: 请求参数值没有做对应的检查, 就做类型转换操作.

## (3) 405
	405也是一个状态码. 表示服务器找不到请求处理方法(service)
	1)错误产生的原因
		检查service方法是否正确重写?
		a. service方法名称写错
		b. 方法抛出的异常大于继承的类

练习: 重建一个maven工程
生成部署描述文件..dep   指定好服务器

写一个DateServlet, 输出当前的日期
http://localhost:8089/day01-lab/date, 输出 2018-07-24


课后练习: 课下写一个BmiServlet , 它依据身高和体重计算人的bmi指数
bmi指数=体重(公斤) / 身高(米) / 身高的平方
如果bmi指数 < 19  过轻
    bmi指数 > 25  过重
   	 其他                   正常
   	 
  用户打开浏览器, 在浏览器地址栏输入http://ip:port/day01-lab/bmi?height=1.88&width=60 
  回车   输出bim:22   正常/过轻/过重
    	       

mysql 数据库默认端口号: 3306
Oracle 数据库默认端口号: 1521
tomcat 默认端口号:8080


# day02

