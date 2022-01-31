package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDetails;

@WebServlet("/BookAdd")
@MultipartConfig
public class BookAdd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String bookname=req.getParameter("bname");
			String author=req.getParameter("author");
			String price =req.getParameter("price");
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			
			BookDetails b = new BookDetails(bookname, author, price,fileName);
			//System.out.println(b);
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConncetion());
			boolean f = dao.addBooks(b);
			HttpSession session = req.getSession();
			
			if(f) {
				String path = getServletContext().getRealPath("")+"book";
				File file = new File(path);
				part.write(path+File.separator+ fileName);
				session.setAttribute("succMsg", "Book Add successfullt!");
				 resp.sendRedirect("admin/add_book.jsp");
			}else {
				session.setAttribute("failedMsg", "Something worng on server");
				resp.sendRedirect("admin/add_book.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
