package com.web.lms.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;

import com.web.lms.model.LmsAttachment;
import com.web.lms.model.LmsLeaveApplication;
import com.web.lms.model.LmsUser;
import com.web.lms.utility.FileUploadUtility;

@RestController
public class FileUploadRest {

	@Autowired
	private HttpSession httpSession;
	@Autowired
	private LmsAttachmentHome lmsAttachmentHome;
	@Autowired
	private LmsLeaveApplicationHome lmsLeaveApplicationHome;
	@Autowired
	private LmsUserHome lmsUserHome;

	@RequestMapping(value = "/fileupload/", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file, UriComponentsBuilder ucBuilder) {
		if (file != null) {
			//System.out.println(file.getSize());
		} else {
			//System.out.println("File is null");
		}
		/*
		 * int i=1; try { for (MultipartFile multipartFile : files) {
		 * FileUploadUtility.uploadSingleFile(multipartFile,
		 * multipartFile.getName()+ i++); } } catch (Exception e) { return new
		 * ResponseEntity<String>("Failed", HttpStatus.NO_CONTENT); }
		 * 
		 */ return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<Void> uploadFile(MultipartHttpServletRequest request) {

		try {
			Iterator<String> itr = request.getFileNames();
			String contextPath = request.getContextPath();
			String requestURL = request.getRequestURI();
			String ticketFolderName = "";
			String userName=null;
			String fileUploadPath = "";
			String userGroup = "";
			
			try{
				userName=httpSession.getAttribute("networkid").toString();
				userGroup = httpSession.getAttribute("groupName").toString();
				
				userName = "reaz";
				userGroup = "Test";

			}catch(Exception e){
				// log error
			}

			if (httpSession.getAttribute("ticketNumberToCreateFolder") != null)
				ticketFolderName = httpSession.getAttribute("ticketNumberToCreateFolder").toString();
			
			ticketFolderName = "1";

			while (itr.hasNext()) {
				// Current Date and Time
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");//dd/MM/yyyy
                Date now = new Date();
                String strDate = sdfDate.format(now);

				String uploadedFile = itr.next();
				MultipartFile file = request.getFile(uploadedFile);
				String mimeType = file.getContentType();
//				String filename = file.getOriginalFilename();
				String filename = userGroup + "_" +"("+strDate+")"+ "_"+ file.getOriginalFilename();
				
				filename = filename.replace('&', '_');
				filename = filename.replace("#", "_");
				filename = filename.replace("%", "_");
				filename = filename.replace("/", "_");
				filename = filename.replace("+", "_");
				filename = filename.replace(":", "_");
				filename = filename.replace(";", "_");
				filename = filename.replace("\"", "_");
				filename = filename.replace("'", "_");
				filename = filename.replace("<", "_");
				filename = filename.replace(",", "_");
				filename = filename.replace(">", "_");
				filename = filename.replace("?", "_");
				
				byte[] bytes = file.getBytes();

				//System.out.println(filename + " " + bytes);

				fileUploadPath = FileUploadUtility.uploadSingleFile(file, filename, ticketFolderName);

				if (!fileUploadPath.equalsIgnoreCase("")) {
					// Save To DB
					
					LmsAttachment lmsAttachment = new LmsAttachment();
					LmsLeaveApplication lmsLeaveApplication = lmsLeaveApplicationHome.findById(1);
					
					
					lmsAttachment.setLmsLeaveApplication(lmsLeaveApplication);
					//lmsAttachment.setLmsUser(lmsUser);
					lmsAttachment.setFilename(filename);

					try {
						// Save To DB
						lmsAttachmentHome.persist(lmsAttachment);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
					// Update Summery table
					try {
						// Save to DB
						
					} catch (Exception e) {
						// Failed to update summery table info
					}


					//System.out.println("Success");
				}

				// FileUpload newFile = new FileUpload(filename, bytes,
				// mimeType);

				// fileUploadService.uploadFile(newFile);
			}
		} catch (

		Exception e) {
			return new ResponseEntity<Void>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Void>( HttpStatus.OK);
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downl1oad(HttpServletResponse response, @RequestParam String fileName) {
		File file = null;
		InputStream is = null;
		OutputStream os = null;
		String ticketFolderName = null;
		/*Tomcat Rootpath*/
		//String rootPath = System.getProperty("catalina.home");
		/*JBoss RootPath*/
		String rootPath="/u03/jboss/apps";
		//String rootPath = System.getProperty("jboss.server.base.dir");
		//System.out.println(fileName);
		try {
			ticketFolderName = httpSession.getAttribute("ticketNumberToCreateFolder").toString();
			file = new File(rootPath + File.separator + "AttachmentRepository" + File.separator + ticketFolderName
					+ File.separator + fileName);
			is = new FileInputStream(file);

			// MIME type of the file
			response.setContentType("application/octet-stream");
			// Response header
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			// Read from the file and write into the response
			os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.flush();
			
		} catch (Exception e) {

		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (os != null) {
					is.close();
				}
			} catch (IOException io) {
				// Log that failed to close filestreams
			}
		}
	}
}
