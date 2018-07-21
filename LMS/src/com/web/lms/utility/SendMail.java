package com.web.lms.utility;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 

public class SendMail {
	
	public static void SendMailForRegistration(String emailid,String name,String flag){  
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		     props.put("mail.transport.protocol", "smtp");
		     final String username = "lmscca01@gmail.com";//
		     final String password = "april@123";
		     try{
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password);
		                             }});

		   // -- Create a new message --
		     Message msg = new MimeMessage(session);

		  // -- Set the FROM and TO fields --
		     msg.setFrom(new InternetAddress("lmscca01@gmail.com"));
		     msg.setRecipients(Message.RecipientType.TO, 
		                      InternetAddress.parse(emailid,false));
		     if (flag=="Request") {
		     msg.setSubject("New User Registration");
		     msg.setText("Dear Sir, One user approval request is pending at your end, User name is :" + name);
		     }
		     else if(flag=="notifyuser") {
		    	 msg.setSubject("Information Updated By Admin");
			     msg.setText("Dear Sir, Your information is updated by admin. Please check your status from menu(User Management-> Update Profile)");
		     }
		     
		     msg.setSentDate(new Date());
		     Transport.send(msg);
		     System.out.println("Message sent.");
		  }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
		  }
	
	        public static void SendMailForApproval(String emailid,String flag){  
		    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		     props.put("mail.transport.protocol", "smtp");
		     final String username = "lmscca01@gmail.com";
		     final String password = "april@123";
		     try{
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password);
		                             }});

		   // -- Create a new message --
		     Message msg = new MimeMessage(session);

		  // -- Set the FROM and TO fields --
		     msg.setFrom(new InternetAddress("lmscca01@gmail.com"));
		   /*msg.setRecipients(Message.RecipientType.TO, 
		                      InternetAddress.parse(emailid,false));*/
		     msg.addRecipients(Message.RecipientType.CC, 
                     InternetAddress.parse(emailid));
		                      
		     if (flag=="request") {
		     msg.setSubject("Leave Approval Request");
		     msg.setText("Dear Sir, You have received this mail since you have got an leave approval request");
		     }
		     else if(flag=="approve") {
		    	 msg.setSubject("Leave Approval confirmation Request");
			     msg.setText("Dear Sir, You have received this mail to inform you that your leave request is approved");
		     }
		     else if(flag=="reject") {
		    	 msg.setSubject("Leave Approval rejection");
			     msg.setText("Dear Sir, You have received this mail since your leave request is cancelled");
		     }
		     
		     msg.setSentDate(new Date());
		     Transport.send(msg);
		     System.out.println("Message sent.");
		  }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
		  }
}
