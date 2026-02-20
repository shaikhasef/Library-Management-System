package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class addSerlvet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		BookBean bb = new BookBean();
		bb.setBookId(req.getParameter("bookid"));
		bb.setBookName(req.getParameter("bookname"));
		bb.setBookAuthor(req.getParameter("bookauthor"));	
		bb.setPrice(Integer.parseInt(req.getParameter("bookprice")));
		int row = new BookDAO().addBook(bb);
	
			req.setAttribute("books", new BookDAO().getBook());
			req.getRequestDispatcher("home.jsp").forward(req, res);
		
		
		
	}
}
