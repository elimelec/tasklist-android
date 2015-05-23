package com.coloredflare.tasklist.datatypes;

public class List {
	private final int id;
	private final String name;
	private final Tasks tasks;

	public List(int id, String name, Tasks tasks) {
		this.id = id;
		this.name = name;
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return name;
	}

    public int getId() {
        return id;
    }

	public Tasks getTasks() {
		return tasks;
	}
}
