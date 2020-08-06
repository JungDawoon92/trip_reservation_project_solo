package aqua.module;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader r =
					Resources.getResourceAsReader(
							"SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			r.close();
		} catch (Exception e) { }
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}