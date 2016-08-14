package com.bj.mybatis.entity;

public class Emp 
{
 private Integer id;
 private String  name;
 //private Dept    dept;//后续双向关系的时候记得添加
 
 public Emp() {}
 
 public Integer getId() {
   return id;
 }
 public void setId(Integer id) {
   this.id = id;
 }
 public String getName() {
   return name;
 }
 public void setName(String name) {
   this.name = name;
 }
// public Dept getDept() {
//   return dept;
// }
// public void setDept(Dept dept) {
//   this.dept = dept;
// }

 @Override
 public String toString() {
   return "Emp [id=" + id + ", name=" + name + ", dept="  + "]";
 }
 
 
 
 
}
