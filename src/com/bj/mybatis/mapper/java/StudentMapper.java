package com.bj.mybatis.mapper.java;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bj.mybatis.entity.Student;

public interface StudentMapper {
	
	public int addStudent(Student student);
	public Student getStuById(Integer id);
	public Student getByAge_If(@Param("age")Integer age);
	public Student getStudentBy_Where(Student student);
	
	public List<Student> getStudentBy_Choose_When_Otherwise(Map<String,Object> map);
	public List<Student> getStudentBy_Foreach(Map<String,Object> map);
	public List<Student> getStudentBy_Trim(Student student);
	public void insertStudentBy_Trim(Student student);
	public void updateStudentBy_Set(Student student);
	
}
