package com.gowthamvel.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;
import com.gowthamvel.util.ConnectionUtil;

public class TicketTransactionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(TicketTransaction u) throws PersistenceException {
		try {
			String sql = "insert into ticket_transaction(user_id,type,subject,description,priority) values(?,?,?,?,?)";
			Object[] params = { u.getUId().getId(), u.getType(), u.getSubject(), u.getDescription(), u.getPriority() };
			jdbcTemplate.update(sql, params);
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Duplicated Entry", e);

		}

	}

	public void update(TicketTransaction u) throws PersistenceException {
		try {
			String sql = "update Ticket_Transaction set status=?  where user_id=?";
			Object[] params = { u.getUId().getId(), u.getStatus() };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry");
		}
	}

	public void updateStatus(TicketTransaction u) throws PersistenceException {
		try {
			String sql = "update Ticket_Transaction set status=?,updated_date=? where user_id=? and id=?";
			Object[] params = { u.getStatus(), LocalDateTime.now(), u.getUId().getId(), u.getId() };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry");
		}
	}

	public void updateDesc(TicketTransaction u) throws PersistenceException {
		try {
			String sql = "update Ticket_Transaction set description=? where user_id=? and id=?";
			Object[] params = { u.getDescription(), u.getUId().getId(), u.getId() };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry");
		}
	}

	public void delete(int id) throws PersistenceException {
		try {
			String sql = "delete from Ticket_Transaction where id=?  ";
			Object[] params = { id };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry");
		}
	}

	public List<TicketTransaction> list() {
		String sql = "select * from ticket_transaction ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			TicketTransaction u = new TicketTransaction();
			User us = new User();
			us.setId(rs.getLong("ID"));
			u.setId(rs.getLong("ID"));
			u.setUId(us);
			u.setPriority("HIGH");
			u.setSubject(rs.getString("SUBJECT"));
			u.setDescription(rs.getString("DESCRIPTION"));
			u.setCreatedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
			u.setUpdatedDate(rs.getTimestamp("UPDATED_DATE").toLocalDateTime());
			u.setStatus(rs.getString("STATUS"));
			return u;

		});
	}

	public List<TicketTransaction> listById(long id) throws PersistenceException {
		try {
			String sql = "select id,type,subject,description,priority,created_date,updated_date,status from Ticket_Transaction where user_id=?";
			Object[] params = { id };
			return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
				TicketTransaction u = new TicketTransaction();
				u.setId(rs.getLong("ID"));
				u.setType(rs.getString("type"));
				u.setSubject(rs.getString("subject"));
				u.setDescription(rs.getString("description"));
				u.setPriority(rs.getString("priority"));
				u.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
				u.setStatus(rs.getString("STATUS"));
				return u;
			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry");
		}

	}

	public TicketTransaction findId(String sub, String desc, long uid) throws PersistenceException {
		try {
			String sql = "select id from Ticket_Transaction where subject=? and description=? and user_id=? ";
			Object[] params = { sub, desc, uid };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				TicketTransaction u = new TicketTransaction();
				u.setId(rs.getLong("id"));
				return u;
			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry");
		}

	}

}
