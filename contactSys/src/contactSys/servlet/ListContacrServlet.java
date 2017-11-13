package contactSys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactSys.dao.ContactDao;
import contactSys.dao.impl.ContactDaoImpl;
import contactSys.entity.Contact;


public class ListContacrServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//取出数据
		ContactDao dao = new ContactDaoImpl();
		List<Contact> list= dao.findAll();
		//存于域对象中
		request.setAttribute("contacts", list);
		
		//跳转jsp
		request.getRequestDispatcher("/listContact.jsp").forward(request, response);;
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
