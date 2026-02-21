package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String name = new AdminDAO().login(req.getParameter("name"), req.getParameter("pass"));
		if(name==null) {
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			pw.println("<p style='color:red;'> Invalid Username or Password </p>");
			req.getRequestDispatcher("index.html").include(req, res);
		}else {
			req.getServletContext().setAttribute("name", name);
			req.setAttribute("books", new BookDAO().getBook());
			req.getRequestDispatcher("home.jsp").forward(req, res);
		}
	}
}
