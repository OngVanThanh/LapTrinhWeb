package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
	 private String message;
	 @SuppressWarnings("serial")
	 public void init() throws ServletException {
	 // Do required initialization
	 message = "Hello World";
	 }
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 // Set response content type
	 response.setContentType("text/html");
	 // Actual logic goes here.
	 PrintWriter out = response.getWriter();
	 out.println("<h1>" + message + "</h1>");
	 }
	 public void destroy() {
	 // do nothing.
	 }
	}