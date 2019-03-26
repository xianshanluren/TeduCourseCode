package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public HelloServlet(){
		System.out.println("HelloServlet�Ĺ�����");
	}

	@Override
	/**
	 * Servlet�����յ����������Servlet��
	 * service��������������
	 * ע: 
	 * 		�����Ὣ�������ݰ��е����ݽ�������, Ȼ���ŵ�
	 * 		request��������(Ҳ����˵,������Ա��ͬ�ٽ���
	 * 		�������ݰ�, ֻ��Ҫ����request�����ṩ�ķ���
	 * 		�Ϳ��Ի���������ݰ��е���������)
	 * 
	 * 		������Աֻ��Ҫ��������д����Ӧ��������, 
	 * 		���������Ӧ�����л�ȡ������
	 * 		,Ȼ��������Ӧ���ݰ�,�����͸������
	 * 
	 * 		�������
	 * 		��Ӧ����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servelt��service����");
		//��ȥ�������ֵ
		/**
		 * ͨ����������ṩ�ķ���,��ȡ�������
		 * ע: qty: �����������,������ʵ�ʵ����������һ��,
		 * 		����᷵��nullֵ.
		 */
		String qty = request.getParameter("qty");
		Integer.parseInt(qty);//Ӧ�ö��û�����Ĳ������������
		
		//��һ��
		/*
		 * ����content-type: ��Ϣͷ��ֵ
		 * 	ע: 
		 * 		content-type��Ϣͷ��������: ���������,
		 * 		���������ص����ݵ�����
		 */
		response.setContentType("text/html");
		/*ͨ����Ӧ�����õ�һ�������*/
		PrintWriter out = response.getWriter();
		/*��������д����Ӧ�������� */
		out.println("<h1>Hello Kitty</h1>");
		
		/*�ر���*/
		out.close();
		
		//�ڶ���: ����(�ù���eclipse)
		
		//������: ��һ���ļ���    ���������ļ�web.xml
		
		//���Ĳ�: ����(copy)�����ļ�
			
		
		//���岽: ����servlet����
		
	}


	
	
}
