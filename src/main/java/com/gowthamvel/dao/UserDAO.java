package com.gowthamvel.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.User;
import com.gowthamvel.util.ConnectionUtil;

public class UserDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(User u) throws PersistenceException {
		try {
			String sql = "insert into Users(name,email_id,password) values(?,?,?)";
			Object[] params = { u.getName(), u.getEmailid(), u.getPassword() };
			jdbcTemplate.update(sql, params);
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Your entry is Duplicated", e);

		}
	}

	public void update(User u) throws PersistenceException {
		try {
			String sql = "update Users set name=?  where id=?";
			Object[] params = { u.getId(), u.getName() };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

	public void delete(int id) throws PersistenceException {
		try {
			String sql = "delete from Users where id=?  ";
			Object[] params = { id };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

	public List<User> list() {
		String sql = "select * from users ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			User u = new User();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			u.setEmailid(rs.getString("EMALI_ID"));
			u.setPassword(rs.getString("PASSWORD"));
			u.setActive(rs.getBoolean("ACTIVE"));
			return u;

		});
	}

	public User listById(int id) throws PersistenceException {
		try {
			String sql = "select id,name from users where id=?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				User u = new User();
				u.setId(rs.getLong("ID"));
				u.setName(rs.getString("NAME"));
				return u;
			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

	public User findPassword(long uid) throws PersistenceException {
		try {
			String sql = "select password from users where id=?";
			Object[] params = { uid };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				User u = new User();
				u.setPassword(rs.getString("PASSWORD"));

				return u;

			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

	public User findIdbypass(String password) throws PersistenceException {
		try {
			String sql = "select id from users where password=?";
			Object[] params = { password };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				User u = new User();
				u.setId(rs.getLong("ID"));
				return u;

			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

	public User findId(String emailid) throws PersistenceException {
		try {
			String sql = "select id,name,password from users where email_id=?";
			Object[] params = { emailid };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				User u = new User();
				u.setId(rs.getLong("ID"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				return u;

			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

	public User findEmailId(long uid) throws PersistenceException {
		try {
			String sql = "select email_id from users where id=?";
			Object[] params = { uid };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				User u = new User();
				u.setEmailid(rs.getString("EMAIL_ID"));

				return u;

			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

}
