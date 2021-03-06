package com.gowthamvel.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Mail {

	private Mail() {
	}

	// User mail
	public static void sendSimpleMail(String mail, String message, Long ticketId) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator("ticketapp.gvel@gmail.com", "ticketapp.gvel1234"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ticketapp.gvel@gmail.com");
		email.setSubject("Ticket Management System");
		email.setMsg(message + "" + ticketId);
		email.addTo(mail);
		email.setStartTLSEnabled(true);
		email.send();

	}

	public static void sendSimpleMail(String mail, String message, String solution) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator("ticketapp.gvel@gmail.com", "ticketapp.gvel1234"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ticketmanagement.tms@gmail.com");
		email.setSubject("Ticket Management System");
		email.setMsg(message + "" + solution);
		email.addTo(mail);
		email.setStartTLSEnabled(true);
		email.send();

	}

	public static void sendSimpleMail(String mail, String message) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator("ticketapp.gvel@gmail.com", "ticketapp.gvel1234"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ticketmanagement.tms@gmail.com");
		email.setSubject("Ticket Management System");
		email.setMsg(message + "");
		email.addTo(mail);
		email.setStartTLSEnabled(true);
		email.send();

	}
}
