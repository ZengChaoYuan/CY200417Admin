package util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlSessionUtil {//封装SqlSession
  private static SqlSessionFactory factory;
  
  static {
	    //获取mybatis-config.xml文件流
		InputStream ips=SqlSessionUtil.class.
				getClassLoader().getResourceAsStream("mybatis-config.xml");
		//获取SqlSessionFactoryBuilder
	    SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
	    //获取SqlSessionFactory,需要通过SqlSessionFactoryBuilder对象获取，传入配置文件
	    factory=builder.build(ips);
  }
  
  public static SqlSession getSqlSession() {
	  return factory.openSession();
  }
  
}
