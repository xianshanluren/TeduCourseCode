package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class AddUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			UserDAO dao = new UserDAO();
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			
			dao.save(user);
			
//			out.println("<h1>添加用户成功</h1>");
//			out.println("<p><a href='list'>用户列表</a></p>");
			/*重定向的一个细节: 重定向之前容器会先清空响应对象上的所有数据*/
			out.println("添加成功");//out流: 相当于把数据写到响应对象里面
			/*重定向到用户列表*/
			response.sendRedirect("list");//当整个service 方法执行完后, 才会生成一个重定向数据包
			
			//发送一段js脚本给浏览器   setTimeout(function(){location='list'})
		
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙, 稍后重试");
		}
		
	
	}
	

}
