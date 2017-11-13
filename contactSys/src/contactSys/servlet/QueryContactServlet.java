package contactSys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactSys.dao.ContactDao;
import contactSys.dao.impl.ContactDaoImpl;
import contactSys.entity.Contact;


public class QueryContactServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("id");
		//根据id查联系人
		ContactDao dao = new ContactDaoImpl();
		Contact contact= dao.findById(id);
		//保存
		request.setAttribute("contact", contact);
		
		//跳转
		request.getRequestDispatcher("/updateContact.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
