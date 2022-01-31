package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.SellerDAOImpl;
import com.DAO.SellerDao;
import com.DB.DBConnect;
import com.entity.Seller;

@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			//response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter()
			try{
				// fetch all from data
			
				
				// baki ka data yaha nikalna...
					String name =request.getParameter("fname");
					String email =request.getParameter("email");
					String phno =request.getParameter("phone");
					String password =request.getParameter("password");
					String check=request.getParameter("check");
					//System.out.println(fname+" "+email+" "+phone+" "+password);
			// 		create user object and set all data to that object..
					
					Seller seller = new Seller();
					seller.setName(name);
					seller.setEmail(email);
					seller.setPhno(phno);
					seller.setPassword(password);
					
				
					HttpSession session = request.getSession();
					if(check!=null) {
						SellerDAOImpl dao=new SellerDAOImpl(DBConnect.getConncetion());
						boolean f = dao.sellerInsert(seller);
						
						if(f) {
							session.setAttribute("succMsg", "Registration Successfully!");
							response.sendRedirect("register.jsp");
						}else {
							session.setAttribute("failedMsg", "Something wrong on server!");
							response.sendRedirect("register.jsp");

						}
					}else {
						session.setAttribute("failedMsg", "Please check mark");
						response.sendRedirect("register.jsp");

					}
					
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
