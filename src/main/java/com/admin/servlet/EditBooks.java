package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDetails;

@WebServlet("/EditBooks")
public class EditBooks extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String bookname=req.getParameter("bname");
			String author=req.getParameter("author");
			String price =req.getParameter("price");
			
			BookDetails b = new BookDetails();
			b.setBookId(id);
			b.setBookname(bookname);
			b.setAuthor(author);
			b.setPrice(price);
			
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConncetion());
			boolean f = dao.updateEditBooks(b);
			
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Book Add successfullt!");
				 resp.sendRedirect("admin/all_book.jsp");
			}else {
				session.setAttribute("failedMsg", "Something worng on server");
				resp.sendRedirect("admin/all_book.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
