package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	
	public ArrayList<BookBean> getBook(){
		ArrayList<BookBean> al = new ArrayList<BookBean>();
		try {
		Connection con = DBConnect.getConnect();
		PreparedStatement ps = con.prepareStatement("select * from books");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			BookBean bb = new BookBean();
			bb.setBookId(rs.getString(1));
			bb.setBookName(rs.getString(2));
			bb.setBookAuthor(rs.getString(3));
			bb.setPrice(rs.getInt(4));
			al.add(bb);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return al;
		
	}

}
