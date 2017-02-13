package com.gowthamvel.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.mail.EmailException;

import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.mail.Mail;
import com.gowthamvel.model.ERole;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.EmployeeTicket;
import com.gowthamvel.model.Issue;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;

public class AssignEmployeeDAO {

	public void assignEmTicket(long uid, long tid, long eid, String reply, String state) throws PersistenceException {
		try {
			// LoginDAO ld = new LoginDAO();
			EmployeeDAO em = new EmployeeDAO();
			//
			// String emp = em.findEmailid(eid).toString();
			// String password = em.findpassword(eid).toString();
			//
			// if (ld.check(emp, password)) {
			TicketTransaction t = new TicketTransaction();
			Employee e = new Employee();
			User u = new User();
			EmployeeTicket et = new EmployeeTicket();
			EmployeeTicketDAO edao = new EmployeeTicketDAO();
			EmployeeDAO ed = new EmployeeDAO();
			String email = ed.findEmailid(eid).getEmailid();
			System.out.println(email);
			t.setId(tid);
			et.setTicket(t);
			e.setId(eid);
			et.setEId(e);
			u.setId(uid);
			et.setUId(u);
			et.setReply(reply);
			edao.save(et);
			Mail.sendSimpleMail(email, "Ticket Assigned Sucessfully.Your Employee id is:", eid);
			t.setStatus(state);
			t.setUId(u);
			TicketTransactionDAO tdao = new TicketTransactionDAO();
			tdao.updateStatus(t);

			// }
		} catch (Exception pe) {
			throw new PersistenceException("INVALID ENTRY", pe);
		}
	}

	public void newStatus(long id, long iid, String text) throws PersistenceException {
		TicketTransactionDAO dao = new TicketTransactionDAO();
		TicketTransaction t = new TicketTransaction();
		User u = new User();
		u.setId(iid);
		t.setId(id);
		t.setUId(u);
		t.setStatus(text);
		t.setUpdatedDate(LocalDateTime.now());
		dao.updateStatus(t);
	}

	public void reassign(long id, long tid, long uId) throws PersistenceException, EmailException {
		EmployeeTicket et = new EmployeeTicket();
		TicketTransaction tt = new TicketTransaction();

		Employee e = new Employee();
		e.setId(id);
		EmployeeDAO ed = new EmployeeDAO();

		String email = ed.findEmailid(id).getEmailid();

		User u = new User();
		u.setId(uId);

		et.setEId(e);
		et.setUId(u);
		tt.setId(tid);
		et.setTicket(tt);
		EmployeeTicketDAO etdao = new EmployeeTicketDAO();
		etdao.save(et);
		Mail.sendSimpleMail(email, "Ticket Reassigned Sucessfully.Your New Employee id is:", id);

	}

	public void cleared(long id, String soln) throws PersistenceException, EmailException {
		Issue i = new Issue();
		EmployeeDAO ed = new EmployeeDAO();

		String email = ed.findEmailid(id).getEmailid();

		TicketTransaction tid = new TicketTransaction();
		IssueDAO idao = new IssueDAO();
		tid.setId(id);
		i.setTid(tid);
		i.setSolution(soln);
		idao.save(i);
		Mail.sendSimpleMail(email, "Your Ticket Has been given solution.Your Solution is:", soln);

	}

	public void adminDelete(long id) throws PersistenceException, EmailException {
		ERole er = new ERole();
		er.setId(2);
		long iid = er.getId();
		if (iid == 2)

		{
			TicketTransactionDAO td = new TicketTransactionDAO();
			td.delete((int) id);
		}

	}

}
