package com.coloredflare.tasklist.db;

public class List {
	private final int id;
	private final String name;

	public List(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

    public int getId() {
        return id;
    }
}
