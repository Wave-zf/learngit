package contactSys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contactSys.dao.ContactDao;
import contactSys.dao.impl.ContactDaoImpl;
import contactSys.entity.Contact;


public class AddContactSerlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		String phone =request.getParameter("phone");
		String email=request.getParameter("email");
		String qq=request.getParameter("qq");
		//��װ����
		Contact contact = new Contact();
		contact.setName(name);
		contact.setGender(gender);
		System.out.println(age);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		//����dao
		ContactDao dao = new ContactDaoImpl();
		//�ж��ظ�
		if(dao.checkContact(name)){
			request.setAttribute("msg", "�����ظ������������롣");
			request.getRequestDispatcher("/addContact.jsp").forward(request,response);
			return;
		}
		
		
		
		
		dao.addContact(contact);
		//��ת��
		response.sendRedirect("ListContacrServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
