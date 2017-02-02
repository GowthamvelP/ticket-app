package com.gowthamvel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.model.ERole;
import com.gowthamvel.util.ConnectionUtil;

public class ERoleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(ERole u) {
		String sql = "insert into e_role(name) values(?)";
		Object[] params = { u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void update(ERole u) {
		String sql = "update e_role set name=?  where id=?";
		Object[] params = { u.getId(), u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from ERole where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<ERole> list() {
		String sql = "select * from e_role ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			ERole u = new ERole();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			u.setActive(rs.getBoolean("ACTIVE"));
			return u;

		});
	}

	public ERole listById(int id) {

		String sql = "select id,name from e_role where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			ERole u = new ERole();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			return u;
		});

	}

}
