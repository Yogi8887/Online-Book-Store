package com.DAO;

import java.util.List;

import com.entity.BookDetails;
import com.entity.Order;

public interface OrderDAO {
	
	public boolean addOrder(Order c);
	
	public List<Order> getAllOrder();
	
	public Order getOrderById(int id);

	public boolean updateBuyBooks(Order o);
}
