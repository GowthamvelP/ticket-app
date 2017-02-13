package com.gowthamvel.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.Department;
import com.gowthamvel.util.ConnectionUtil;

public class DepartmentDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Department u) throws PersistenceException {
		try {
			String sql = "insert into department(name) values(?)";
			Object[] params = { u.getName() };
			jdbcTemplate.update(sql, params);
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Duplicate entry", e);

		}
	}

	public void update(Department u) throws PersistenceException {
		try {
			String sql = "update department set name=?  where id=?";
			Object[] params = { u.getId(), u.getName() };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);

		}
	}

	public void delete(int id) throws PersistenceException {
		try {
			String sql = "delete from department where id=?  ";
			Object[] params = { id };
			jdbcTemplate.update(sql, params);
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Duplicate entry", e);

		}
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

	public Department listById(int id) throws PersistenceException {
		try {
			String sql = "select id,name from department where id=?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				Department u = new Department();
				u.setId(rs.getLong("ID"));
				u.setName(rs.getString("NAME"));
				return u;
			});
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Duplicate entry", e);

		}

	}

	public Department listByName(String name) throws PersistenceException {
		try {
			String sql = "select id from department where name=?";
			Object[] params = { name };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				Department u = new Department();
				u.setId(rs.getLong("ID"));
				return u;
			});
		} catch (DuplicateKeyException e) {
			throw new PersistenceException("Duplicate entry", e);

		}

	}

}