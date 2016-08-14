package text.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.bj.mybatis.entity.Dept;
import com.bj.mybatis.entity.Lock;
import com.bj.mybatis.mapper.java.DeptMapper;
import com.bj.mybatis.mapper.java.LockMapper;

public class TestCascadeSelect {
	SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void before() throws IOException{
		InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	
	/**
	 *@Description:根据id获取dept
	 *@Author:du_minchao
	 *@Version:
	 *@CreateDate:2016年3月16日
	 *@return:void
	 */
	
	@Test
	public  void testGetDeptById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
		
		//因为在lock中有key
		Dept lockById = mapper.getDeptById(1);
		System.out.println(lockById);
		//System.out.println(lockById.getKey().getKeyName());
		
		sqlSession.commit();
		
		if(sqlSession != null){
			sqlSession.close();
		}
		
	}
	
	
	/**
	 *@Description:	测试向数据库中添加Student
	 *@Author:du_minchao
	 *@Version:1.0
	 *@CreateDate:2016年3月15日
	 *@return:void
	 */
	@Test
	public  void testGetLockById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		LockMapper mapper = sqlSession.getMapper(LockMapper.class);
		
		//因为在lock中有key
		Lock lockById = mapper.getLockById(1);
		System.out.println(lockById);
		//System.out.println(lockById.getKey().getKeyName());
		
		sqlSession.commit();
		
		if(sqlSession != null){
			sqlSession.close();
		}
		
	}
	
}
