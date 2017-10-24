package edu.java.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value="/upload",name="file-upload")
@MultipartConfig(maxFileSize=1024*1024*10)
public class UploadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(Part part:req.getParts()) {
			Collection<String> headers = part.getHeaderNames();
			headers.forEach(header->{
				try {
					resp.getWriter().println(header + ":" + part.getHeader(header));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		resp.getWriter().println("Upload successfully");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for(Part part:req.getParts()) {
			Collection<String> headers = part.getHeaderNames();
			headers.forEach(header->{
				try {
					resp.getWriter().println(header + ":" + part.getHeader(header));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		resp.getWriter().println("Upload successfully");
	}
}
