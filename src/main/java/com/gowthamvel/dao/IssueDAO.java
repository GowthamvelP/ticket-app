package com.gowthamvel.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowthamvel.model.Issue;
import com.gowthamvel.model.TicketTransaction;
import com.gowthamvel.util.ConnectionUtil;

public class IssueDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Issue u) {
		String sql = "insert into issues (ticket_id,solution) values(?,?)";
		Object[] params = { u.getTid().getId(), u.getSolution() };
		jdbcTemplate.update(sql, params);

	}

	public void update(Issue u) {
		String sql = "update issues set solution=?  where ticket_id=?";
		Object[] params = { u.getSolution(), u.getTid().getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {
		String sql = "delete from issues where id=?  ";
		Object[] params = { id };
		jdbcTemplate.update(sql, params);

	}

	public List<Issue> list() {
		String sql = "select * from users ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Issue u = new Issue();
			TicketTransaction tt = new TicketTransaction();
			tt.setId(rs.getLong("ID"));
			u.setTid(tt);
			u.setSolution(rs.getString("SOLUTION"));

			return u;

		});
	}

	public Issue listById(int id) {

		String sql = "select id,solution from Issue where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Issue u = new Issue();
			u.setId(rs.getLong("ID"));
			u.setSolution(rs.getString("SOLUTION"));
			return u;
		});

	}
}
