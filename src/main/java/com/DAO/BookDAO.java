package com.DAO;

import java.util.List;

import com.entity.BookDetails;

public interface BookDAO {
	public boolean addBooks(BookDetails b);
	
	public List<BookDetails> getAllBook();

	public BookDetails getBookById(int id);
	
	public boolean updateEditBooks(BookDetails b);
	
	public boolean deleteBooks(int id);
	
	public List<BookDetails> getNewBook();
	
	public List<BookDetails> getBookBySearch(String ch);
	
	
}


