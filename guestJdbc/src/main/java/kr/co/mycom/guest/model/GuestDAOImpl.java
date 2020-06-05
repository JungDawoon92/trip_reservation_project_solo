package kr.co.mycom.guest.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class GuestDAOImpl implements GuestDAO {
	private JdbcTemplate jdbcTemplate;

	
	// guestDAO 가 JdbcTemplate 에 의존하고 있으므로
	// Setter 방식으로 Injection 하기 위해
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void insertGuest(GuestDTO dto) {
		String sql = "insert into guest(no,name,pwd,email, "
				+ " home,content,regdate)"
				+ " values((select NVL(max(no),0)+1 from guest), "
				+ " ?,?,?,?,?,SYSDATE)";
		
		Object[] arr = { dto.getName(), dto.getPwd(), dto.getEmail(), dto.getHome(), dto.getContent() };
		jdbcTemplate.update(sql,arr);
	}
	
	@Override
	public List listGuest() {
		String sql = "select * from guest order by no desc";
		
		return jdbcTemplate.queryForList(sql);
	}
}
