package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public HelloServlet(){
		System.out.println("HelloServlet的构造器");
	}

	@Override
	/**
	 * Servlet容器收到请求后会调用Servlet的
	 * service方法来处理请求
	 * 注: 
	 * 		容器会将请求数据包中的数据解析出来, 然后存放到
	 * 		request对象里面(也就是说,开发人员不同再解析
	 * 		请求数据包, 只需要调用request对象提供的方法
	 * 		就可以获得请求数据包中的所有数据)
	 * 
	 * 		开发人员只需要将处理结果写到响应对象里面, 
	 * 		容器会从响应对象中获取处理结果
	 * 		,然后生成响应数据包,并发送给浏览器
	 * 
	 * 		请求对象
	 * 		响应对象
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servelt的service方法");
		//速去请求参数值
		/**
		 * 通过请求对象提供的方法,读取请求参数
		 * 注: qty: 是请求参数名,必须与实际的请求参数名一致,
		 * 		否则会返回null值.
		 */
		String qty = request.getParameter("qty");
		Integer.parseInt(qty);//应该对用户填入的参数类型做检查
		
		//第一步
		/*
		 * 设置content-type: 消息头的值
		 * 	注: 
		 * 		content-type消息头的作用是: 告诉浏览器,
		 * 		服务器返回的数据的类型
		 */
		response.setContentType("text/html");
		/*通过响应对象拿到一个输出流*/
		PrintWriter out = response.getWriter();
		/*将处理结果写到响应对象里面 */
		out.println("<h1>Hello Kitty</h1>");
		
		/*关闭流*/
		out.close();
		
		//第二步: 编译(用工具eclipse)
		
		//第三步: 建一个文件夹    部署描述文件web.xml
		
		//第四部: 部署(copy)描述文件
			
		
		//第五步: 启动servlet容器
		
	}


	
	
}
