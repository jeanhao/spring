package com.mvc.model;

public class SuperUser extends User {
	private String name;

	public String getName() {
		return name;
	}

	public SuperUser(String name,User user) {
		super(user.getId(),user.getUserName(),user.getPassword());
		this.name = name;
	}

	public SuperUser() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SuperUser [name=" + name + ", toString()=" + super.toString()
				+ "]";
	}
	
}
