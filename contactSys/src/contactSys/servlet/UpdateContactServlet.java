package contactSys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactSys.dao.ContactDao;
import contactSys.dao.impl.ContactDaoImpl;
import contactSys.entity.Contact;


public class UpdateContactServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//接受参数
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		String phone =request.getParameter("phone");
		String email=request.getParameter("email");
		String qq=request.getParameter("qq");
		//封装对象
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setGender(gender);
		System.out.println(age);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		//调用方法
		ContactDao dao = new ContactDaoImpl();
		dao.updateContact(contact);
		//跳转
		response.sendRedirect("ListContacrServlet");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
