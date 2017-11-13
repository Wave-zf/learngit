package message.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.jar.Attributes.Name;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.regexp.internal.recompile;

import message.util.JdbcUntil;
import message.dao.MessageDao;
import message.entity.Message;

public class MessageDaoImpl implements MessageDao {

	@Override
	//�������
	public void addMessage(Message message) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="INSERT INTO message(id,NAME,texts) VALUE (?,?,?)";
			//����prestem
			stmt= conn.prepareStatement(sql);
			//���ò���
			String id = UUID.randomUUID().toString().replace("-", "");
			stmt.setString(1,id );
			stmt.setString(2, message.getName());
			stmt.setString(3, message.getTexts());
			
			//ִ��
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt);
		}
	}

	@Override
	public void deleteMessage(String id) {
		
	}

	@Override
	//������������
	public List<Message> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="SELECT id,NAME,texts FROM message;";
			//����prestem
			stmt= conn.prepareStatement(sql);
			//ִ��
			rs= stmt.executeQuery();
			List<Message> list = new ArrayList<Message>();
			while(rs.next()){
				Message m = new Message();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				if(rs.getString("texts")!=null){
					m.setTexts(rs.getString("texts"));
					list.add(m);
				}
				
				
			}
			return list;
		
		}catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt ,rs);
		}
		return null;
	}

	@Override
	//ע�����
	public boolean checkMessage(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="SELECT * FROM message where name=?;";
			//����prestem
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, name);
			//ִ��
			rs =stmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt ,rs);
		}
		return false;
	}

	@Override
	//��¼�ж�
	public boolean enter(String name,String password) {
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet re = null;
		try {
			//��װע��
			conn= JdbcUntil.getConnection();
			//Ԥ����sql
			String sql="SELECT * FROM message WHERE NAME=? AND PASSWORD=?";
			//ִ��Ԥ����
			stmt= conn.prepareStatement(sql);
			//����
			stmt.setString(1, name);
			stmt.setString(2, password);
			//ִ��sql
			re= stmt.executeQuery();
			
			//��¼
			if(re.next()){
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement) stmt,re);
		}
		return false;

	}

	@Override
	//�����Լ�������
	public Message findById(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="SELECT * FROM message where id=?;";
			//����prestem
			stmt= conn.prepareStatement(sql);
			//ִ��
			rs= stmt.executeQuery();
			Message m = null;
			while(rs.next()){
				m = new Message();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setTexts(rs.getString("texts"));
				
			}
			return m;
		
		}catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt ,rs);
		}
		return null;
	}

	@Override
	//����û�
	public void addUser(Message message) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="INSERT INTO message(id,NAME,PASSWORD,texts,phone,qq) VALUE (?,?,?,?,?,?)";
			//����prestem
			stmt= conn.prepareStatement(sql);
			//���ò���
			String id = UUID.randomUUID().toString().replace("-", "");
			stmt.setString(1,id );
			stmt.setString(2, message.getName());
			stmt.setString(3, message.getPassword());
			stmt.setString(4, message.getTexts());
			stmt.setString(5, message.getPhone());
			stmt.setString(6, message.getQq());
			
			//ִ��
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt);
		}
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

}
