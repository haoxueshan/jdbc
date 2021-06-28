package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;

import com.doman.User;

public class UserDao {
	public User findByUsername(String username) throws ClassNotFoundException, SQLException{
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/test"+"?useUnicode=true&characterEncoding=utf8";
		String name="root";
		String password="123456";
		Class.forName(driverClassName);
		Connection con=DriverManager.getConnection(url,name,password);
		String sql="select * from user where username=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs=pst.executeQuery();

		if(!(rs.next())){
			return null;
		}
		else{
			rs.next();
			User user=new User();
			user.setUsername(rs.getString("username"));
			user.setUsername(rs.getString("password"));
			return user;
		}
	}
	public void add(User user) throws ClassNotFoundException, SQLException {
		
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/test"+"?useUnicode=true&characterEncoding=utf8";
		String name="root";
		String password="123456";
		Class.forName(driverClassName);
		Connection con=DriverManager.getConnection(url,name,password);
		String sql="insert into user values(?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		int rs=pst.executeUpdate();
		
	}
	public static Boolean longin(String uname ,String pass) throws SQLException, ClassNotFoundException {
		String driverClassName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/test"+"?useUnicode=true&characterEncoding=utf8";
		String name="root";
		String password="123456";
		Class.forName(driverClassName);
		Connection con=DriverManager.getConnection(url,name,password);
		String sql="select * from user where username=? and password=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, uname);
		pst.setString(2, pass);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}

}
