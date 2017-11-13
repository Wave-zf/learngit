package message.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import message.dao.MessageDao;
import message.dao.impl.MessageDaoImpl;
import message.entity.Message;

public class AddMessageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("utf-8");
		
		//String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
		HttpSession session= request.getSession(false);
		String name= (String) session.getAttribute("loginName");
		String texts= new String(request.getParameter("texts").getBytes("ISO-8859-1"),"utf-8");
		
		Message message = new Message();
		message.setName(name);
		message.setTexts(texts);
		
		MessageDao dao = new MessageDaoImpl();
		dao.addMessage(message);
		response.sendRedirect("ListMessageServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
