package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDetails;
import com.entity.Seller;

public class BookDAOImpl implements BookDAO {

	private Connection conn;
	
	
	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addBooks(BookDetails b) {
		boolean f = false;
		try {
			String sql = "insert into book_details(bookname,author,price,photo) values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookname());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPrice());
			pstmt.setString(4, b.getPhoto());
			int i=pstmt.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	// get all book
	public List<BookDetails> getAllBook() {
		List<BookDetails> list= new ArrayList<BookDetails>();
		BookDetails b = null;
		try {
			String sql = "select * from book_details;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setPhoto(rs.getString(5));
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BookDetails getBookById(int id) {
		BookDetails b= null;
		try {
			String sql = "select * from book_details where bookId=?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setPhoto(rs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean updateEditBooks(BookDetails b) {
		boolean f = false;
		try {
			String sql = "update book_details set bookname=?,author=?,price=? where bookId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookname());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPrice());
			pstmt.setInt(4, b.getBookId());
			int i=pstmt.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public boolean deleteBooks(int id) {
		boolean f = false;
			try {
				String sql = "delete from book_details where bookId=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				int i = pstmt.executeUpdate();
				if(i==i) {
					f=true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return f;
	}
	
	public List<BookDetails> getNewBook() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {
			String sql = "select * from book_details where bookId=?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<BookDetails> getBookBySearch(String ch) {
		
			List<BookDetails> list= new ArrayList<BookDetails>();
			BookDetails b = null;
			try {
				String sql = "select * from book_details where bookname LIKE ? or author LIKE ?;";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				 
				pstmt.setString(1, "%"+ch+"%");
				pstmt.setString(2, "%"+ch+"%");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					b = new BookDetails();
					b.setBookId(rs.getInt(1));
					b.setBookname(rs.getString(2));
					b.setAuthor(rs.getString(3));
					b.setPrice(rs.getString(4));
					b.setPhoto(rs.getString(5));
					list.add(b);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;

		
	}
	
	
	
	

	
}
