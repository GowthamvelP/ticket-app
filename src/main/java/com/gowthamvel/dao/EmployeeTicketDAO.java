package com.gowthamvel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.model.Employee;
import com.gowthamvel.model.EmployeeTicket;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.model.User;
import com.gowthamvel.util.ConnectionUtil;

public class EmployeeTicketDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(EmployeeTicket u) {
		String sql = "insert into Employee_Ticket(t_id,e_id,u_id,reply) values(?,?,?,?)";
		Object[] params = { u.getTicket().getId(), u.getEId().getId(), u.getUId().getId(), u.getReply() };
		jdbcTemplate.update(sql, params);

	}

	public void update(EmployeeTicket u) {
		String sql = "update Employee_Ticket set reply=?  where u_id=?";
		Object[] params = { u.getReply(), u.getUId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from Employee_Ticket where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<EmployeeTicket> list() {
		String sql = "select * from Employee_ticket ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			TicketTransaction du = new TicketTransaction();
			Employee e = new Employee();
			User us = new User();
			EmployeeTicket et = new EmployeeTicket();
			du.setId(rs.getLong("T_ID"));
			et.setTicket(du);
			e.setId(rs.getLong("E_ID"));
			et.setEId(e);
			us.setId(rs.getLong("U_ID"));
			et.setUId(us);
			et.setReply(rs.getString("REPLY"));
			return et;

		});
	}

	public List<EmployeeTicket> listById(long eid, long uid) {

		String sql = "select id,t_id,u_id,e_id,reply from employee_ticket where e_id=? and u_id=?";
		Object[] params = { eid, uid };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
			TicketTransaction du = new TicketTransaction();
			Employee e = new Employee();
			User us = new User();
			EmployeeTicket et = new EmployeeTicket();
			et.setId(rs.getLong("ID"));
			du.setId(rs.getLong("T_ID"));
			et.setTicket(du);
			us.setId(rs.getLong("U_ID"));
			et.setUId(us);
			e.setId(rs.getLong("E_ID"));
			et.setEId(e);
			et.setReply(rs.getString("REPLY"));
			return et;
		});

	}
}
