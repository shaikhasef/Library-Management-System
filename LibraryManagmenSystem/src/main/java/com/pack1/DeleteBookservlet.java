package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteBookservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("bookid");
		int row = new BookDAO().deleteBook(id);
		ArrayList<BookBean> book = new BookDAO().getBook();
		req.getSession().setAttribute("books",book);
		req.getRequestDispatcher("home.jsp").forward(req, res);
		
	}

}
