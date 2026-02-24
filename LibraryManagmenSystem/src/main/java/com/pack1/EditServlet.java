package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("bookid");
		ArrayList<BookBean> al = (ArrayList<BookBean>) req.getSession().getAttribute("books");
		BookBean bb = null;
		for(BookBean pb : al) {
			bb = pb;
			if(id.equals(pb.getBookId())) {
				break;
			}
		}
		req.setAttribute("bean", bb);
		req.getRequestDispatcher("editbook.jsp").forward(req, res);
		
	}

}
