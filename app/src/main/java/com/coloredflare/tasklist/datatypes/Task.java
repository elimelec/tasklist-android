package com.coloredflare.tasklist.datatypes;

public class Task {
	private final int id;
	private final String name;
	private final boolean checked;

	public Task(int id, String name, boolean checked) {
		this.name = name;
		this.id = id;
		this.checked = checked;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	public boolean isChecked() {
		return checked;
	}
}

