package com.lv.code.springboot.model;

import lombok.Data;

@Data
public class Student extends BaseStudent {

	private String name;
	private int age;

    @Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
