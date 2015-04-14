package com.coloredflare.tasklist.db;

public class Task {
	private final int id;
	private final String name;

	public Task(int id, String name) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}
}

