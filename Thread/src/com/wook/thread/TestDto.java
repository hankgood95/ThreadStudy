package com.wook.thread;

public class TestDto {
	private String name;
	private int num;
	
	public TestDto(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int age) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "TestDto [name=" + name + ", age=" + num + "]";
	}
	
	
}
