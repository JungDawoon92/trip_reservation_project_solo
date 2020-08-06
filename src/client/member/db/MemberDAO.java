package client.member.db;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			Reader reader =
					Resources.getResourceAsReader("client/mapping/SqlMapConfig.xml");
			sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(Exception e) {
			throw new RuntimeException("SqlMapClient instance" + e, e);
		}
	}
	public static  MemberBean isMember(String id){
		MemberBean member = null;
		SqlSession session = sqlSessionFactory.openSession();
		member = (MemberBean) session.selectOne("isMember", id);
		session.close();
		return member;
	}
	
}
