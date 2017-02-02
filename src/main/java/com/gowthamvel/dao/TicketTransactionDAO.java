package com.gowthamvel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.model.Department;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;
import com.gowthamvel.util.ConnectionUtil;

public class TicketTransactionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(TicketTransaction u) {
		String sql = "insert into ticket_transaction(id,user_id,emp_id,dept_id,subject,description,created_date,updated_date,status) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { u.getId(), u.getUId().getId(), u.getEId().getId(), u.getDId().getId(), u.getSubject(),
				u.getDescription(), u.getCreatedDate().toLocalDate(), u.getUpdatedDate(), u.getStatus() };
		jdbcTemplate.update(sql, params);

	}

	public void update(TicketTransaction u) {
		String sql = "update TicketTransaction set status=?  where user_id=?";
		Object[] params = { u.getUId().getId(), u.getStatus() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from TicketTransaction where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<TicketTransaction> list() {
		String sql = "select * from ticket_transaction ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			TicketTransaction u = new TicketTransaction();
			User us = new User();
			Employee eu = new Employee();
			Department du = new Department();
			us.setId(rs.getLong("ID"));
			u.setId(rs.getLong("ID"));
			u.setUId(us);
			eu.setId(rs.getLong("ID"));
			u.setEId(eu);
			du.setId(rs.getLong("ID"));
			u.setDId(du);
			u.setSubject(rs.getString("SUBJECT"));
			u.setDescription(rs.getString("DESCRIPTION"));
			u.setCreatedDate(rs.getDate("CREATED_DATE"));
			u.setUpdatedDate(rs.getDate("UPDATED_DATE"));
			u.setStatus(rs.getString("STATUS"));
			return u;

		});
	}

	public TicketTransaction listById(int id) {

		String sql = "select status from Ticket_Transaction where user_id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			TicketTransaction u = new TicketTransaction();
			User us = new User();
			us.setId(rs.getLong("ID"));
			u.setUId(us);
			u.setStatus(rs.getString("STATUS"));
			return u;
		});

	}

}
