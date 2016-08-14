package com.bj.mybatis.entity;

import java.util.Date;

public class Student {
	//id  name     score  birth  age 
	private Integer id;
	private String  name;
	private double  score;
	private Date birth;
	private int age;
	
	public Student() {
	}

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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score
				+ ", birth=" + birth + ", age=" + age + "]";
	}
	 
}
