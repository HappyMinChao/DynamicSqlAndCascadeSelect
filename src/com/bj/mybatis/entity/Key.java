package com.bj.mybatis.entity;

public class Key {
	private Integer id;
	private String  keyName;
	public Key() {}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	@Override
	public String toString() {
		return "Key [id=" + id + ", keyName=" + keyName + "]";
	}

}
