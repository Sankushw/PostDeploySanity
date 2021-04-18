package lib;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void FaliureMail() throws EmailException{
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sanjay1893@gmail.com", "Summerhai1@"));
		email.setSSLOnConnect(true);
		email.setFrom("sanjay1893@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("The test has failed ... :--)");
		email.addTo("sankushw@in.ibm.com");
		email.send();

	}
	public static void FailureMailWithAttach() throws EmailException, MalformedURLException{

		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("test-output/emailable-report.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("PostDeployment_SanityReport_CSAT&M");
		attachment.setName("SanityReport_CSAT&M");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sanjay1893@gmail.com", "Summerhai1@"));
		email.setSSLOnConnect(true);
		email.addTo("sankushw@in.ibm.com");
		email.setFrom("sanjay1893@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("The test has failed. :-(");
		
		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
	}

	public static void PassMail() throws EmailException{
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sanjay1893@gmail.com", "Summerhai1@"));
		email.setSSLOnConnect(true);
		email.setFrom("sanjay1893@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("post-deployment Sanity test has been passed... :-)");
		email.addTo("sankushw@in.ibm.com");
		email.send();

	}
	public static void PassMailWithAttach() throws EmailException, MalformedURLException{

		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("test-output/emailable-report.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("PostDeployment_SanityReport_CSAT&M");
		attachment.setName("SanityReport_CSAT&M");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sanjay1893@gmail.com", "Summerhai1@"));
		email.setSSLOnConnect(true);
		email.addTo("sankushw@in.ibm.com");
		email.setFrom("sanjay1893@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("post-deployment Sanity test has been passed... :-)");
		
		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
	}
}