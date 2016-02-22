package mz.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class EmailReport {
	
	private final String EMAIL_DOMAIN_BAHASO = "@bahaso.com";
	
	private final String [] EMAIL_BACKEND_TEAM = new String[]{"darwin","andre","augustaniusdalay","chandra"};
	
	private final String [] EMAIL_FRONTEND_WEB_TEAM = new String[]{"krisantus"};
	
	private final String [] EMAIL_FRONTEND_IOS_TEAM = new String[]{"salim","lucy"};
	
	private final String [] EMAIL_FRONTEND_ANDROID_TEAM = new String[]{"hendrysetiadi"};
	
	private final String [] EMAIL_TESTENGINEER_TEAM = new String[]{"zullidar","ademahendra"};
	
	
	private final String EMAIL_FROM = "test";
	
	private final String SMTP_HOST = "email-smtp.us-west-2.amazonaws.com";
	
	private final String SMTP_PORT = "25";
	
	private final String SMTP_USERNAME = "AKIAIZZ47Y2AOKDXOWDQ";
	
	private final String SMTP_PASSWORD = "AgiveMs9zrIduX8l9FcOhk5VEtua2Zyj4bEOK8jOBzWE";
	
	
	public enum Team { BACKEND, FRONTEND_WEB, FRONTEND_IOS, FRONTEND_ANDROID, TEST_ENGINEER }
	
	public EmailReport(){}
	
	private ArrayList<Address> emailDestination(String [] email) throws AddressException
	{
		ArrayList<Address> emailDestination = new ArrayList<Address>();
		for (int i=0; i<email.length; i++) {
			emailDestination.add(new InternetAddress(email[i]+EMAIL_DOMAIN_BAHASO));
		}
		return emailDestination;
	}
	
	private ArrayList<Address> switchEmailDestination(Team team) throws AddressException
	{
		switch(team)
		{
		case BACKEND:
			return this.emailDestination(EMAIL_BACKEND_TEAM);
		case FRONTEND_WEB:
			return this.emailDestination(EMAIL_FRONTEND_WEB_TEAM);
		case FRONTEND_ANDROID:
			return this.emailDestination(EMAIL_FRONTEND_ANDROID_TEAM);
		case FRONTEND_IOS:
			return this.emailDestination(EMAIL_FRONTEND_IOS_TEAM);
		case TEST_ENGINEER:
			return this.emailDestination(EMAIL_TESTENGINEER_TEAM);
		}
		return null;
	}
	
	private String getTestResultHTML()
	{
		
		try {
			File file = new File("test-output/emailable-report.html");
			List<String> list = FileUtils.readLines(file,"UTF-8");
			StringBuilder contentBuilder = new StringBuilder();
			for(String line : list)
			{
				contentBuilder.append(line);
			}
			return contentBuilder.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void sendHTMLEmail(String scenario, Team... teams){
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(properties,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("zullidar@bahaso.com", "bahaso.com2015123");
			}
		});
		
		try{
			ArrayList<Address> emailDestination = new ArrayList<Address>();
			for(Team team : teams)
			{
				emailDestination.addAll(this.switchEmailDestination(team));
			}
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL_FROM+EMAIL_DOMAIN_BAHASO));
			message.addRecipients(Message.RecipientType.TO,emailDestination.toArray(new Address[emailDestination.size()]));
			message.setSubject("Functional Testing Result ["+scenario+"] on "+(new SimpleDateFormat("d M y H:m:s").format(new Date())));
			message.setContent(getTestResultHTML(),"text/html");
			Transport.send(message);
			
		}catch(MessagingException ex)
		{
			ex.printStackTrace();
		}
	}
	
}
