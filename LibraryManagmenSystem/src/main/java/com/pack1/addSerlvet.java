package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class addSerlvet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		try {
		BookBean bb = new BookBean();
		bb.setBookId(req.getParameter("bookid"));
		bb.setBookName(req.getParameter("bookname"));
		bb.setBookAuthor(req.getParameter("bookauthor"));	
		bb.setPrice(Integer.parseInt(req.getParameter("bookprice")));
		int row = new BookDAO().addBook(bb);
		ArrayList<BookBean> book = new BookDAO().getBook();
		if(row>0) {
			req.getSession().setAttribute("books",book);
			req.getRequestDispatcher("home.jsp").forward(req, res);
		
		}else {
			
			req.getSession().setAttribute("books",book);
			req.getRequestDispatcher("home.jsp").forward(req, res);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
