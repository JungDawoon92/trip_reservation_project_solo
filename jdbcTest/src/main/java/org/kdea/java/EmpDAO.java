package org.kdea.java;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("empDao")
public class EmpDAO {
	DataSource dataSource;
	
	@Autowired
	public EmpDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Emp> getEmpList() {
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select * from empl";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		list = (List)jdbcTemplate.queryForList(sql);
		list = jdbcTemplate.query(sql, new EmpRowMapper());
		return list;
	}
	
	public boolean insertEmp(Emp emp) {
		String sql = "INSERT INTO empl"
				+ "(empno,ename,deptno,sal,job) VALUES (?,?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int rows = jdbcTemplate.update(sql,
				new Object[] { emp.getEmpno(), emp.getEname(), emp.getDeptno(), emp.getSal(), emp.getJob() });
		return rows > 0 ? true : false;
				
	}
	
	public boolean deleteEmp(int empno) {
		String sql = "delete from empl where empno=" + empno;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int rows = jdbcTemplate.update(sql);
		return rows > 0 ? true : false;
	}
	
	public boolean updateEmp(Emp emp) {
		String sql = "UPDATE empl set deptno=?, sal=? where empno=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int rows = jdbcTemplate.update(sql,
				new Object[] {emp.getDeptno(), emp.getSal(), emp.getEmpno() });
		return rows > 0 ? true : false;
	}
	
	public Emp getEmp(int empno) {
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select * from empl where empno=" + empno;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		list = jdbcTemplate.query(sql, new EmpRowMapper());
		return list.get(0);
	}
}
