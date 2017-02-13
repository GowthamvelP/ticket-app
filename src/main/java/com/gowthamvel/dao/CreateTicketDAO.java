package com.gowthamvel.dao;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.mail.Mail;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class CreateTicketDAO {
	public void register(String n, String e, String p) throws PersistenceException {
		try {
			User u = new User();
			u.setName(n);
			u.setEmailid(e);
			u.setPassword(p);
			UserDAO ud = new UserDAO();
			ud.save(u);
		} catch (DuplicateKeyException de) {
			throw new PersistenceException("Cannot add duplicate entry", de);
		}
	}

	public void createTicket(long userId, String type, String subject, String description, String priority)
			throws PersistenceException, EmailException {
		try {
			LoginDAO ld = new LoginDAO();
			UserDAO ud = new UserDAO();

			String email = ud.findEmailId(userId).getEmailid();
			String password = ud.findPassword(userId).getPassword();
			System.out.println(email);
			System.out.println(password);
			ld.check(email, password);
			TicketTransactionDAO tdao = new TicketTransactionDAO();
			TicketTransaction t = new TicketTransaction();
			User u = new User();
			u.setId(userId);
			t.setUId(u);
			t.setType(type);
			t.setPriority(priority);
			// t.setDId(d.listByName(type));
			t.setSubject(subject);
			t.setDescription(description);
			tdao.save(t);

			Long ticketId = tdao.findId(subject, description, userId).getId();

			Mail.sendSimpleMail(email, "Ticket Created Sucessfully.Your Ticket id is:", ticketId);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("Login Failed", e);
		}
	}
	public List<TicketTransaction>  details(long uid) throws PersistenceException
	{
	User u= new User();
	u.setId(uid);
	TicketTransaction tt = new TicketTransaction();
	tt.setUId(u);
	TicketTransactionDAO tdao = new TicketTransactionDAO();
	 return tdao.listById(uid);
	}

}
