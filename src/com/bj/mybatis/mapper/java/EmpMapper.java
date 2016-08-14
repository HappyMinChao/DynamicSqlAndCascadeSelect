package com.bj.mybatis.mapper.java;

import java.util.List;

import com.bj.mybatis.entity.Emp;

public interface EmpMapper
{
 public List<Emp> getEmpByDeptId(Integer deptId); 
}