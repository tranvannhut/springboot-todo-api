package com.example.demo.services.impl;

public enum StatusEnum {
	PLANNING(1, "planning"), DOING(2, "doing"), COMPLETE(3, "complete");

	private final int id;
	private final String name;

	StatusEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
