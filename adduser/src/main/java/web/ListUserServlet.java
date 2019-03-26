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
		//׼���������
		response.setContentType("text/html;charset=UTF-8");//������Ӧͷ
		PrintWriter out = response.getWriter();
		/*
		 * 1. �������û���Ϣ��ѯ����
		 */
		try {
			UserDAO dao = new UserDAO();
			List<User> users = dao.findAll();
			/*
			 *�Ա�����ʽ��������û�����Ϣ 
			 */
			out.print("<table border='1' width='60%' cellpadding='0' cellspacing='0'>  ");
			out.println("<tr><td>ID</td><td>�û���</td><td>����</td><td>����</td></tr>");
			for(User u : users){
				int id = u.getId();
				String username = u.getUsername();
				String password = u.getPassword();
				String email = u.getEmail();
				out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+password+"</td><td>"+email+"</td></tr>");
			}
			out.print("</table>");
			out.println("<p><a href='addUser.html'>����û�</a></p>");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("ϵͳ��æ,�Ժ�����");
		} 
		
	}
	

}
