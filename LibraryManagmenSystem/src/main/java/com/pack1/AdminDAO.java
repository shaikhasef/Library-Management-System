package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {
	
	public boolean register(AdminBean ab) {
		int row=0;
		try {
			Connection con =DBConnect.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into admin values(?,?,?,?,?,?)");
			ps.setString(1, ab.getName());
			ps.setString(2, ab.getPass());
			ps.setString(3, ab.getFname());
			ps.setString(4, ab.getLname());
			ps.setString(5, ab.getMail());
			ps.setString(6, ab.getNum());
			row = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return row>0;
	}
	public String login(String name ,String pass) {
		
	String AdminName=null;
		try {
			Connection con =DBConnect.getConnect();
			PreparedStatement ps = con.prepareStatement("select fname,lname from admin where name=? and pass=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			AdminName=rs.getString(1)+" "+rs.getString(2);
	}catch (Exception e) {
		e.printStackTrace();
	}
		return AdminName;
	}

}
