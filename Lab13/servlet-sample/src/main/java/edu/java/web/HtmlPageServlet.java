package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/page",name="html-servlet")
public class HtmlPageServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter writer = resp.getWriter();
	writer.println("<html><head><title>Welcome</title>");
	writer.println("<style>\r\n" + 
			"table, th, td {\r\n" + 
			"    border: 1px solid black;\r\n" + 
			"    border-collapse: collapse;\r\n" + 
			"}\r\n" + 
			"th, td {\r\n" + 
			"    padding: 5px;\r\n" + 
			"    text-align: left;    \r\n" + 
			"}\r\n" + 
			"</style>");
	writer.println("</head>");
	
	writer.println("<body><h1>Student</h1>"
			+ "<table style=\"width:10%\">\r\n" + 
			"<tr>\r\n" + 
			"    <th>#</th>\r\n" + 
			"    <th>Name</th>\r\n" + 
			"  </tr>"
			+ "<tr>\r\n" + 
			"    <td>1</td>\r\n" + 
			"    <td>Nguyen Van A</td>\r\n" + 
			"  </tr>"
			+ "<tr>\r\n" 
			+ "<td>2</td>\r\n"
			+ "<td>Nguyen Van B</td>"
			+ "</tr>"
			+"</table>"
			+ "</body>");
	
	writer.println("</html>");
	
}
}
