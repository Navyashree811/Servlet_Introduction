package com.bridgelabz.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Login Servlet Testing", urlPatterns = { "/LoginServlet" }, initParams = {
		@WebInitParam(name = "user", value = "Navya"), @WebInitParam(name = "password", value = "Anokhi181") })

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");

		String userID = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		String nameValidate = "^[A-Z][a-z]{2,}";
		String passwordValidate = "^(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[a-z])(?=.*[A-Z]).{8,}$";

		if (userID.equals(user) && userID.matches(nameValidate) && password.equals(pwd)) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
		}
		if (userID.equals(user) && userID.matches(nameValidate) && password.equals(pwd)
				&& password.matches(passwordValidate)) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red> Either User Name Or Password is Wrong </font> ");
			rd.include(req, resp);
		}

	}

}
