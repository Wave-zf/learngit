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
	//添加留言
	public void addMessage(Message message) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//建立连接
			conn= JdbcUntil.getConnection();
			String sql ="INSERT INTO message(id,NAME,texts) VALUE (?,?,?)";
			//创建prestem
			stmt= conn.prepareStatement(sql);
			//设置参数
			String id = UUID.randomUUID().toString().replace("-", "");
			stmt.setString(1,id );
			stmt.setString(2, message.getName());
			stmt.setString(3, message.getTexts());
			
			//执行
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
	//查找所有留言
	public List<Message> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//建立连接
			conn= JdbcUntil.getConnection();
			String sql ="SELECT id,NAME,texts FROM message;";
			//创建prestem
			stmt= conn.prepareStatement(sql);
			//执行
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
	//注册查重
	public boolean checkMessage(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//建立连接
			conn= JdbcUntil.getConnection();
			String sql ="SELECT * FROM message where name=?;";
			//创建prestem
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, name);
			//执行
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
	//登录判断
	public boolean enter(String name,String password) {
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet re = null;
		try {
			//安装注册
			conn= JdbcUntil.getConnection();
			//预编译sql
			String sql="SELECT * FROM message WHERE NAME=? AND PASSWORD=?";
			//执行预编译
			stmt= conn.prepareStatement(sql);
			//设置
			stmt.setString(1, name);
			stmt.setString(2, password);
			//执行sql
			re= stmt.executeQuery();
			
			//登录
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
	//查找自己的留言
	public Message findById(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			//建立连接
			conn= JdbcUntil.getConnection();
			String sql ="SELECT * FROM message where id=?;";
			//创建prestem
			stmt= conn.prepareStatement(sql);
			//执行
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
	//添加用户
	public void addUser(Message message) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//建立连接
			conn= JdbcUntil.getConnection();
			String sql ="INSERT INTO message(id,NAME,PASSWORD,texts,phone,qq) VALUE (?,?,?,?,?,?)";
			//创建prestem
			stmt= conn.prepareStatement(sql);
			//设置参数
			String id = UUID.randomUUID().toString().replace("-", "");
			stmt.setString(1,id );
			stmt.setString(2, message.getName());
			stmt.setString(3, message.getPassword());
			stmt.setString(4, message.getTexts());
			stmt.setString(5, message.getPhone());
			stmt.setString(6, message.getQq());
			
			//执行
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
