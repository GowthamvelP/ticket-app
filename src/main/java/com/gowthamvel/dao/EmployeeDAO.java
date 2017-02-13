package com.gowthamvel.dao;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.exception.PersistenceException;
import com.gowthamvel.model.Department;
import com.gowthamvel.model.Employee;
import com.gowthamvel.model.User;
import com.gowthamvel.util.ConnectionUtil;

public class EmployeeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Employee u) throws PersistenceException {
		try {
			String sql = "insert into Employee(role_id,dept_id,name,emailid,password) values(?,?,?,?,?)";
			Object[] params = { u.getRoleId().getId(), u.getDeptId().getId(), u.getName(), u.getEmailid(),
					u.getPassword() };
			jdbcTemplate.update(sql, params);

		} catch (DuplicateKeyException e) {
			throw new PersistenceException("no duplicate entry", e);

		}
	}

	public void update(Employee u) throws PersistenceException {
		try {
			String sql = "update Employee set name=?  where id=?";
			Object[] params = { u.getId(), u.getName() };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);

		}
	}

	public void delete(int id) throws PersistenceException {
		try {
			String sql = "delete from Employee where id=?  ";
			Object[] params = { id };
			jdbcTemplate.update(sql, params);
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

	public List<Employee> list() {
		String sql = "select * from users ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Employee u = new Employee();
			Department du = new Department();
			du.setId(rs.getLong("ID"));
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			u.setDeptId(du);
			u.setEmailid(rs.getString("EMALI_ID"));
			u.setPassword(rs.getString("PASSWORD"));
			u.setActive(rs.getBoolean("ACTIVE"));
			return u;

		});
	}

	public Employee listById(int id) throws PersistenceException {
		try {
			String sql = "select id,name from users where id=?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				Employee u = new Employee();
				u.setId(rs.getLong("ID"));
				u.setName(rs.getString("NAME"));
				return u;
			});

		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);

		}
	}

	public Employee findEmailid(long id) throws PersistenceException {
		try {
			String sql = "select emailid from employee where id=?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				Employee u = new Employee();
				u.setEmailid(rs.getString("EMAILID"));
				return u;
			});

		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);

		}
	}

	public Employee findpassword(long id) throws PersistenceException {
		try {
			String sql = "select password from employee where id=?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				Employee u = new Employee();
				u.setName(rs.getString("password"));
				return u;
			});

		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);

		}
	}

	public User findIdbypass(String password) throws PersistenceException {
		try {
			String sql = "select id from employee where password=?";
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

	public Employee findId(String emailid) throws PersistenceException {
		try {
			String sql = "select id,name,password from employee where emailid=?";
			Object[] params = { emailid };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				Employee u = new Employee();
				u.setId(rs.getLong("ID"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				return u;

			});
		} catch (EmptyResultDataAccessException e) {
			throw new PersistenceException("No such entry", e);
		}
	}

}
