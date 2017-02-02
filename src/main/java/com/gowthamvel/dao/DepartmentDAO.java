package com.gowthamvel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.model.Department;
import com.gowthamvel.util.ConnectionUtil;

public class DepartmentDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Department u) {
		String sql = "insert into department(name) values(?)";
		Object[] params = { u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void update(Department u) {
		String sql = "update department set name=?  where id=?";
		Object[] params = { u.getId(), u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from department where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<Department> list() {
		String sql = "select * from department ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Department u = new Department();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			u.setActive(rs.getBoolean("ACTIVE"));
			return u;

		});
	}

	public Department listById(int id) {

		String sql = "select id,name from department where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Department u = new Department();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			return u;
		});

	}

}