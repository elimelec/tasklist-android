package com.coloredflare.tasklist.db;

public class List {
	private int id;
	private String name;

	public List(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
