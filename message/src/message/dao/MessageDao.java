package message.dao;

import java.util.List;

import message.entity.Message;
import sun.net.www.content.text.plain;

public interface MessageDao {
	public void addMessage(Message message);//添加留言
	public void deleteMessage(String id);
	public List<Message> findAll();//查看所有留言
	public boolean checkMessage(String name);//查重账号
	public void enter();//登录
	public Message findById(String id);//查看自己的留言
	public void addUser(Message message);//添加用户
	public boolean enter(String name, String password);//登录
	
}
