package org.kdea.java;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpRowMapper implements RowMapper<Emp> {
	public Emp mapRow(ResultSet rs, int line) throws SQLException {
		EmpExtractor empExtractor = new EmpExtractor();
		return empExtractor.extractData(rs);
	}
}
