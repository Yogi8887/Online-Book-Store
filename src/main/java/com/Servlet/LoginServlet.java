package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.SellerDAOImpl;
import com.DB.DBConnect;
import com.entity.Seller;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			SellerDAOImpl dao=new SellerDAOImpl(DBConnect.getConncetion());
			HttpSession session = req.getSession();
			
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				Seller sel = new Seller();
				sel.setName("Admin");
				session.setAttribute("sellerObj", sel);
				resp.sendRedirect("admin/home.jsp");
			}else {
				 Seller sel = dao.login(email, password);
				 if(sel!=null) {
					 session.setAttribute("sellerObj", sel);
					 resp.sendRedirect("home.jsp");
				 }else {
					 session.setAttribute("failedMsg", "Email & password Invalid");
					 resp.sendRedirect("login.jsp");
				 }
				resp.sendRedirect("home.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
