package contactSys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactSys.dao.ContactDao;
import contactSys.dao.impl.ContactDaoImpl;


public class DeleteContactServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//����id
		String id = request.getParameter("id");
		//���÷���
		ContactDao dao=new ContactDaoImpl();
		dao.deleteContact(id);
		//��ת
		response.sendRedirect("ListContacrServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
