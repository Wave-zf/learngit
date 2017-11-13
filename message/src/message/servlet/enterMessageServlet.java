package message.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.catalina.Session;

import message.dao.MessageDao;
import message.dao.impl.MessageDaoImpl;
import message.entity.Message;


public class enterMessageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		//pageContext.setAttribute("name",域范围常量);
		
		//查重逻辑
		MessageDao dao = new MessageDaoImpl();
		if(dao.enter(name,password)){
			HttpSession session=request.getSession();
			session.setAttribute("loginName", name);
			response.sendRedirect("ListMessageServlet");
		}else{
			request.setAttribute("msg", "用户名或密码错误，请重新输入");
			request.getRequestDispatcher("/enter.jsp").forward(request,response);
			return;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
