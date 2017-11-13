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


public class AddUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String password = request.getParameter("password");
		String phone =request.getParameter("phone");
		String qq=request.getParameter("qq");
		//域对象存储
		HttpSession session=request.getSession();
		session.setAttribute("loginName", name);
		
		Message message =new Message();
		message.setName(name);
		message.setPassword(password);
		message.setPhone(phone);
		message.setQq(qq);
		//查重逻辑
		MessageDao dao = new MessageDaoImpl();
		
		if(dao.checkMessage(name)){
			request.setAttribute("msg", "用户名重复，请重新输入。");
			request.getRequestDispatcher("/addUser.jsp").forward(request,response);
			return;
		}
		
		dao.addUser(message);
		response.sendRedirect("ok.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
