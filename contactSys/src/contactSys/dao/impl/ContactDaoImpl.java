package contactSys.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.regexp.internal.recompile;

import contactSys.dao.ContactDao;
import contactSys.entity.Contact;
import contactSys.util.JdbcUntil;

public class ContactDaoImpl implements ContactDao{

	@Override
	//���
	public void addContact(Contact contact) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="INSERT INTO contact(id,NAME,gender,age,phone,email,qq) VALUE (?,?,?,?,?,?,?)";
			//����prestem
			stmt= conn.prepareStatement(sql);
			//���ò���
			String id = UUID.randomUUID().toString().replace("-", "");
			stmt.setString(1,id );
			stmt.setString(2, contact.getName());
			stmt.setString(3, contact.getGender());
			stmt.setInt(4, contact.getAge());
			stmt.setString(5, contact.getPhone());
			stmt.setString(6, contact.getEmail());
			stmt.setString(7, contact.getQq());
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
	//�޸�
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="UPDATE contact SET NAME=?,gender=?,age=?,phone=?,email=?,qq=? WHERE id=?";
			//����prestem
			stmt= conn.prepareStatement(sql);
			//���ò���
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getGender());
			stmt.setInt(3, contact.getAge());
			stmt.setString(4, contact.getPhone());
			stmt.setString(5, contact.getEmail());
			stmt.setString(6, contact.getQq());
			stmt.setString(7,contact.getId());
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
	//ɾ��
	public void deleteContact(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="DELETE  FROM contact WHERE id=?;";
			//����prestem
			stmt= conn.prepareStatement(sql);
			//���ò���
			
			stmt.setString(1,id );
			//ִ��
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt);
		}
		
	}

	
	//��ѯ����********ע�����
	public List<Contact> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="SELECT * FROM contact;";
			//����prestem
			stmt= conn.prepareStatement(sql);
			
			//ִ��
			rs =stmt.executeQuery();
			List<Contact> list = new ArrayList<Contact>();
			while (rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setAge(rs.getInt("age"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setQq(rs.getString("qq"));
				list.add(c);
				
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt ,rs);
		}
		return null;
	}

	@Override
	//����id��ѯ
	public Contact findById(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="SELECT * FROM contact where id=?;";
			//����prestem
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, id);
			//ִ��
			rs =stmt.executeQuery();
			Contact c = null;
			if (rs.next()) {
				c = new Contact();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setAge(rs.getInt("age"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setQq(rs.getString("qq"));
				
			}
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		}finally{
			JdbcUntil.close(conn, (Statement)stmt ,rs);
		}
		return null;
	}

	@Override
	public boolean checkContact(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//��������
			conn= JdbcUntil.getConnection();
			String sql ="SELECT * FROM contact where name=?;";
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
	

}
