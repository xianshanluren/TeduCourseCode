package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class ListUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//准备好输出流
		response.setContentType("text/html;charset=UTF-8");//设置响应头
		PrintWriter out = response.getWriter();
		/*
		 * 1. 将所有用户信息查询出来
		 */
		try {
			UserDAO dao = new UserDAO();
			List<User> users = dao.findAll();
			/*
			 *以表格的形式输出所有用户的信息 
			 */
			out.print("<table border='1' width='60%' cellpadding='0' cellspacing='0'>  ");
			out.println("<tr><td>ID</td><td>用户名</td><td>密码</td><td>邮箱</td></tr>");
			for(User u : users){
				int id = u.getId();
				String username = u.getUsername();
				String password = u.getPassword();
				String email = u.getEmail();
				out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+password+"</td><td>"+email+"</td></tr>");
			}
			out.print("</table>");
			out.println("<p><a href='addUser.html'>添加用户</a></p>");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙,稍后重试");
		} 
		
	}
	

}
