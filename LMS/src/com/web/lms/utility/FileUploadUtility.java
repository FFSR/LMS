package com.web.lms.utility;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	public static String uploadSingleFile(MultipartFile file, String name, String ticketFolderName) {

		String fileUploadPath = "";
		BufferedOutputStream stream = null;

		try {

			byte[] bytes = file.getBytes();

			/* Tomcat Rootpath */
			String rootPath = System.getProperty("catalina.home");
			/* JBoss RootPath */
			//String rootPath = System.getProperty("jboss.server.base.dir");
			//String rootPath = "/u03/jboss/apps";
			
			File dir = null;

			if (!ticketFolderName.equals("")) {
				dir = new File(rootPath + File.separator + "AttachmentRepository" + File.separator + ticketFolderName);
				fileUploadPath = File.separator + "AttachmentRepository" + File.separator + ticketFolderName;
			}

			// File dir = new File(rootPath + File.separator +
			// "AttachmentRepository" + File.separator + ticketFolderName +
			// File.separator + ticketHopId);

			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
			stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			System.out.println("Server File Location=" + serverFile.getAbsolutePath());

			return fileUploadPath;

		} catch (Exception ex) {
			// Failed to download file
			return fileUploadPath;
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					// Failed to close filedownload stream
				}
			}
		}
	}
}
