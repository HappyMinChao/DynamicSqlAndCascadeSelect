package text.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.bj.mybatis.entity.Student;
import com.bj.mybatis.mapper.java.StudentMapper;

public class TestDynamicSql {
	SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void before() throws IOException{
		InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void textUpdateStudentBy_Set(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = new Student();
		student.setId(3);
		student.setAge(15);
		student.setBirth(new Date());
		student.setName("z3-------");
		student.setScore(99.9);
		
		mapper.updateStudentBy_Set(student);
		
		//在插入，修改， 删除等操作后记得提交事务
		sqlSession.commit();
		
		if(sqlSession != null){
			sqlSession.close();
		}
		
	}
	
	@Test
	public void textInsertStudentBy_Trim(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = new Student();
		student.setAge(15);
		student.setBirth(new Date());
		student.setName("z311111111");
		student.setScore(99.9);
		
		mapper.insertStudentBy_Trim(student);
		
		//在插入，修改， 删除等操作后记得提交事务
		sqlSession.commit();
		
		if(sqlSession != null){
			sqlSession.close();
		}
		
	}
	
	@Test
	public void textGetStudentBy_Trim(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = new Student();
		student.setAge(15);
		student.setBirth(new Date());
		student.setName("z3");
		student.setScore(99.9);
		
		List<Student> list = mapper.getStudentBy_Trim(student);
		for (Student stu : list) {
			System.out.println(stu);
		}
		//在插入，修改， 删除等操作后记得提交事务
		sqlSession.commit();
		
		if(sqlSession != null){
			sqlSession.close();
		}
		
	}
	
	
	/**
	 *@Description:foreach 使用在 in 查询中
	 *@Author:du_minchao
	 *@Version:
	 *@CreateDate:2016年3月15日
	 *@return:void
	 */
	@Test
	public void textGetStudentBy_Foreach(){

		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("values",Arrays.asList(1,2,3));
		
		List<Student> list = mapper.getStudentBy_Foreach(map);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void textGetStudentBy_Choose_When_Otherwise(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("name", "z3");
		List<Student> list = mapper.getStudentBy_Choose_When_Otherwise(map);
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
	
	/**
	 *@Description:测试where条件
	 *@Author:du_minchao
	 *@Version:
	 *@CreateDate:2016年3月15日
	 *@return:void
	 */
	@Test
	public void textGetStudentBy_Where(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = new Student();

		student.setAge(-15);
		//student.setAge(15);
		student.setName("z3");
		
		student = mapper.getStudentBy_Where(student);
		System.out.println(student);
	}
	
	/**
	 *@Description:测试if动态查询语句， 注意单个参数是会报错 解决方案有两种
	 *@Author:du_minchao
	 *@Version:
	 *@CreateDate:2016年3月15日
	 *@return:void
	 */
	@Test
	public void textGetByAge_If(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		//在使用动态sql传递单参数时，mybatis找不到参数错误现象和处理
		/*
		 * 1 接口方法中添加注解@Param
		   2 XXXMapper.xml配置文件里面写_parameter
			 <select id="getStudentByIf"   parameterType="int" resultType="Student">
			     select * from tbl_student where 1 = 1
			     <if test="_parameter > 0">
			         and age = #{age}
			     </if>
			 </select>

		 */
		Student student = mapper.getByAge_If(24);
		System.out.println(student);
	}
	
	/**
	 *@Description:测试根据id获取Student类实例
	 *@Author:du_minchao
	 *@Version:
	 *@CreateDate:2016年3月15日
	 *@return:void
	 */
	//忘了也Test注解报 unrooted Tests  initializationError
	@Test
	public void textGetStuById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student stuById = mapper.getStuById(3);
		System.out.println(stuById);
		
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
	public  void testAddStudent(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student student = new Student();
		student.setAge(15);
		student.setBirth(new Date());
		student.setName("z3");
		student.setScore(99.9);
		
		int count = mapper.addStudent(student);
		System.out.println(count);
		
		sqlSession.commit();
		
		if(sqlSession != null){
			sqlSession.close();
		}
		
	}
	
}
