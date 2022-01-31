package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.BookDetails;
import com.entity.Seller;

public class SellerDAOImpl implements SellerDao {
	
	private Connection con;

	public SellerDAOImpl(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean sellerInsert(Seller sl) {
		boolean f = false;
		try {
			// user --> database
			String query = "insert into seller(name, email, phno, password) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, sl.getName());
			pstmt.setString(2, sl.getEmail());
			pstmt.setString(3, sl.getPhno());
			pstmt.setString(4, sl.getPassword());
			int i=pstmt.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	public Seller login(String email, String password) {
		Seller sel =  null;
		try {
			String sql="select * from seller where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sel = new Seller();
				sel.setId(rs.getInt(1));
				sel.setName(rs.getString(2));
				sel.setEmail(rs.getString(3));
				sel.setPhno(rs.getString(4));
				sel.setPassword(rs.getString(5));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sel;
	}

	@Override
	public Seller getSellerById(int id) {
		Seller sel= null;
		try {
			String sql = "select * from seller where bookId=?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				sel = new Seller();
				sel.setId(rs.getInt(1));
				sel.setName(rs.getString(2));
				sel.setEmail(rs.getString(3));
				sel.setPhno(rs.getString(4));
				sel.setPassword(rs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sel;
	}

	
	
	

}
