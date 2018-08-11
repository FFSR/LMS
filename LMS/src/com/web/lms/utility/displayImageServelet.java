package com.web.lms.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Servlet implementation class displayImageServelet
 */
@WebServlet("/displayImageServelet")
public class displayImageServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayImageServelet() {
        super();
       // this.filename=filename;
        // TODO Auto-generated constructor stub
    }    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			// you can use FileInputStream to convert any type of file to
			// InputStream
			
			//String location = "C://Cdrive//Feroj//Business//";
			
			String location = "C://Cdrive//apache-tomcat-8.5.28-windows-x64//apache-tomcat-8.5.28//AttachmentRepository//Picture//";
			String filename=request.getParameter("filename");
			String imageN = filename;
			String AddessNew= location.concat(imageN);
		InputStream inputStream = new FileInputStream (AddessNew);
		
		byte[] bytes = IOUtils.toByteArray(inputStream);
		response.setContentType("image/jpeg/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(bytes);
		outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
