package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edited")
public class UpdateBook extends HttpServlet{
	private static final String BookBean = null;

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		BookBean bb = new BookBean();
		bb.setBookId(req.getParameter("bid"));
		bb.setBookName(req.getParameter("bname"));
		bb.setBookAuthor(req.getParameter("bauthor"));
		bb.setPrice(Integer.parseInt(req.getParameter("bprice")));
		int row = new BookDAO().updateBook(bb);
		
		if(row>0) {

			req.getSession().setAttribute("books", new BookDAO().getBook());
			req.getRequestDispatcher("home.jsp").forward(req, res);
		}
	}

}
