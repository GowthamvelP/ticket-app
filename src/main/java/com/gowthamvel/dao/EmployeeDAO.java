package com.gowthamvel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.model.Department;
import com.gowthamvel.model.Employee;
import com.gowthamvel.util.ConnectionUtil;

public class EmployeeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Employee u) {
		String sql = "insert into Employee(role_id,dept_id,name,email_id,password) values(?,?,?)";
		Object[] params = { u.getRoleId().getId(), u.getDeptId().getId(), u.getName(), u.getEmailid(),
				u.getPassword() };
		jdbcTemplate.update(sql, params);

	}

	public void update(Employee u) {
		String sql = "update Employee set name=?  where id=?";
		Object[] params = { u.getId(), u.getName() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from Employee where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

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

	public Employee listById(int id) {

		String sql = "select id,name from users where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Employee u = new Employee();
			u.setId(rs.getLong("ID"));
			u.setName(rs.getString("NAME"));
			return u;
		});

	}

}
