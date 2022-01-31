package com.DAO;

import com.entity.BookDetails;
import com.entity.Seller;

public interface SellerDao {
	
	public boolean sellerInsert(Seller sl);
	
	public Seller login(String email, String password);
	
	public Seller getSellerById(int id);

}
