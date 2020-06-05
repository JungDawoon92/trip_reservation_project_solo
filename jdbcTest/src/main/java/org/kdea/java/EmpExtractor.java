package org.kdea.java;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmpExtractor implements ResultSetExtractor<Emp> {
	public Emp extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Emp emp = new Emp();
		
		emp.setEmpno(resultSet.getInt("EMPNO"));
		emp.setEname(resultSet.getString("ENAME"));
		emp.setHiredate(resultSet.getDate("HIREDATE"));
		emp.setDeptno(resultSet.getInt("DEPTNO"));
		emp.setSal(resultSet.getInt("SAL"));
		emp.setJob(resultSet.getString("JOB"));
		
		return emp;
	}
}
