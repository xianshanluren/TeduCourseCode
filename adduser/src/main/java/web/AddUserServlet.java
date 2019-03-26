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
			
//			out.println("<h1>����û��ɹ�</h1>");
//			out.println("<p><a href='list'>�û��б�</a></p>");
			/*�ض����һ��ϸ��: �ض���֮ǰ�������������Ӧ�����ϵ���������*/
			out.println("��ӳɹ�");//out��: �൱�ڰ�����д����Ӧ��������
			/*�ض����û��б�*/
			response.sendRedirect("list");//������service ����ִ�����, �Ż�����һ���ض������ݰ�
			
			//����һ��js�ű��������   setTimeout(function(){location='list'})
		
		} catch (Exception e) {
			e.printStackTrace();
			out.println("ϵͳ��æ, �Ժ�����");
		}
		
	
	}
	

}
