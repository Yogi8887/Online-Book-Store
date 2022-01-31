package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDetails;
import com.entity.Order;

public class OrderDAOImpl implements OrderDAO {
	private Connection conn;
	

	public OrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addOrder(Order o) {
		boolean f = false;
		try {
			String sql = "insert into book_order(order_id, customer_name, book_name, address, price) values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, o.getOrderid());
			pstmt.setString(2, o.getCustomerName());
			pstmt.setString(3, o.getBookName());
			pstmt.setString(4, o.getAddress());
			pstmt.setString(5, o.getPrice());
			int i=pstmt.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Order> getAllOrder() {
			List<Order> list= new ArrayList<Order>();
			Order o = null;
			try {
				String sql = "select * from book_order;";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					o = new Order();
					o.setId(rs.getInt(1));
					o.setOrderid(rs.getInt(2));
					o.setCustomerName(rs.getString(3));
					o.setBookName(rs.getString(4));
					o.setAddress(rs.getString(4));
					o.setPrice(rs.getString(5));
					list.add(o);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	public Order getOrderById(int id) {
		Order o= null;
		try {
			String sql = "select * from book_order where bookId=?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				o = new Order();
				o.setId(rs.getInt(1));
				o.setOrderid(rs.getInt(2));
				o.setCustomerName(rs.getString(3));
				o.setBookName(rs.getString(4));
				o.setAddress(rs.getString(5));
				o.setPrice(rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	public boolean updateBuyBooks(Order o) {
		boolean f = false;
		try {
			String sql = "update book_order set order_Id=?, customer_name=?, book_name=?, address=?, price=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, o.getOrderid());
			pstmt.setString(2, o.getCustomerName());
			pstmt.setString(3, o.getBookName());
			pstmt.setString(4, o.getAddress());
			pstmt.setString(5, o.getPrice());
			pstmt.setInt(6, o.getId());
			int i=pstmt.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
