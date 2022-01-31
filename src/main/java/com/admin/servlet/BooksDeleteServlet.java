package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;

@WebServlet("/BooksDelete")
public class BooksDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConncetion());
			boolean f = dao.deleteBooks(id);
			
			HttpSession session = req.getSession();
			
			if(f) {
				//System.out.println("Update successfully..");
				session.setAttribute("succMsg", "Book Delete successfullt!");
				resp.sendRedirect("admin/all_book.jsp");
			}else {
				//System.out.println("sothing wrong..");
				session.setAttribute("failedMsg", "Something worng on server");
				resp.sendRedirect("admin/all_book.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
