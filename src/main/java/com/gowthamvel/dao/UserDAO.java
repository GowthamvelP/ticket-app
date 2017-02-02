package com.gowthamvel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.model.User;
import com.gowthamvel.util.ConnectionUtil;

public class UserDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(User u) {
		String sql = "insert into Users(name,email_id,password) values(?,?,?)";
		Object[] params = { u.getName(), u.getEmailid(), u.getPassword() };
		jdbcTemplate.update(sql, params);

	}

	public void update(User u) {
		String sql = "update Users set name=?  where id=?";
		Object[] params = { u.getId(), u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from Users where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

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

	public User listById(int id) {

		String sql = "select id,name from users where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			User u = new User();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			return u;
		});

	}

	public User listByEmailId(String email) {
		String sql = "select password from users where email_id=?";
		Object[] params = { email };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			User u = new User();
			u.setPassword(rs.getString("PASSWORD"));

			return u;

		});

	}

}
