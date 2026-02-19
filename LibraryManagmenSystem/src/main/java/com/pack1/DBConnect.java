package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	static Connection con=null;
	static {
		try {
			Class.forName(DBInfo.driver);
			con=DriverManager.getConnection(DBInfo.dbUrl,DBInfo.dbUname,DBInfo.dbPwd);
		}catch (Exception e) {
			System.out.println("Exception in Connection");
			e.printStackTrace();
		}
	}
	public static Connection getConnect() {
		return con;
	}

}
