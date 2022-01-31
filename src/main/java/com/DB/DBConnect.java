package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con;
	public static Connection getConncetion() {
		try 
		{
			//if(con == null) {
			// driver class load
				Class.forName("com.mysql.jdbc.Driver");
			
			// create a connection..
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store","root","root");
			//}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
