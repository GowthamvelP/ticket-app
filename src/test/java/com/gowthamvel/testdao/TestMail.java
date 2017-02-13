package com.gowthamvel.testdao;

import com.gowthamvel.mail.Mail;

public class TestMail {

	public static void main(String[] args) {
		try {
			String emailId = "gvel6989@gmail.com";
			long ticketId = 0;
			Mail.sendSimpleMail(emailId, "Ticket Created Sucessfully.Your Ticket id is:", ticketId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
