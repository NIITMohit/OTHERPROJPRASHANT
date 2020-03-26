package Utilities;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class Mail {
	public static void main(String[] args) {
		//sendMail(to,subject,body,getNewestFile(folderLocation,fileExtension),FileNameForMail);
		sendMail(
				"avinash.thakur2@mindtree.com",
				"Subject",
				"body",
				getTheNewestFile(System.getProperty("user.dir") + "/Reports/",
						".html"), "Blocker.html");

	}
	

	public static void sendMail(String to, String subject, String body,
			File file, String fileName) {
		final String user = "avinash.thakur0706@gmail.com";
		final String password = "8920429127Akt";
		Properties prop = System.getProperties();
		prop.put("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.user", user);
		prop.setProperty("mail.password", password);
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.debug", "true");
		String port = "587";
		prop.setProperty("mail.smtp.port", port);
		prop.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject(subject);
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(body);
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source = new FileDataSource(file);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(fileName);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("message sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

	public static File getTheNewestFile(String filePath, String ext) {
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("AutomationReport_*"
				+ ext);
		File[] files = dir.listFiles(fileFilter);
		if (files.length > 0) {
			// ** The newest file comes first **//*
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
			System.out.println(theNewestFile.getName());
		}
		return theNewestFile;
	}
}
