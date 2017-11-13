package message.dao;

import java.util.List;

import message.entity.Message;
import sun.net.www.content.text.plain;

public interface MessageDao {
	public void addMessage(Message message);//�������
	public void deleteMessage(String id);
	public List<Message> findAll();//�鿴��������
	public boolean checkMessage(String name);//�����˺�
	public void enter();//��¼
	public Message findById(String id);//�鿴�Լ�������
	public void addUser(Message message);//����û�
	public boolean enter(String name, String password);//��¼
	
}
