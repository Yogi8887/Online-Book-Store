package com.customer.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.OrderDAOImpl;
import com.DB.DBConnect;
import com.entity.Order;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int oid =Integer.parseInt(req.getParameter("oid"));
			String customername=req.getParameter("cname");
			String bookname=req.getParameter("bname");
			String address=req.getParameter("address");
			String price =req.getParameter("price");
			
			Order o = new Order();
			o.setOrderid(oid);
			o.setCustomerName(customername);
			o.setBookName(bookname);
			o.setAddress(address);
			o.setPrice(price);
			
			OrderDAOImpl dao = new OrderDAOImpl(DBConnect.getConncetion());
			boolean f = dao.updateBuyBooks(o);
			HttpSession session = req.getSession();
			
			if(f) {
				//System.out.println("order");
				session.setAttribute("succMsg", "Book Add successfullt!");
				 resp.sendRedirect("home.jsp");
			}else {
				//System.out.println("not order");
				session.setAttribute("failedMsg", "Something worng on server");
				resp.sendRedirect("home.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	

}
