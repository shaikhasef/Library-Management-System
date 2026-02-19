package com.pack1;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		AdminBean ab = new AdminBean();
		ab.setName(req.getParameter("name"));
		ab.setPass(req.getParameter("pass"));
		ab.setFname(req.getParameter("fname"));
		ab.setLname(req.getParameter("lname"));
		ab.setMail(req.getParameter("mail"));
		ab.setNum(req.getParameter("num"));
		try {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		if(new AdminDAO().register(ab)) {
			pw.println("<p style='color:green;'>Registered Successfully..</p>");
			
			req.getRequestDispatcher("index.html").include(req, res);
		}else {
			pw.println("<p style='color:red;'> Registration Faild </p>");
			
			req.getRequestDispatcher("register.html").include(req, res);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
