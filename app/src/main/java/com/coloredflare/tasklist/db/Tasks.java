package com.coloredflare.tasklist.db;

import java.util.ArrayList;
import java.util.Collections;

public class Tasks {
	private final ArrayList<Task> tasks;

	public Tasks() {
		Task[] tasks = new Task[] { new Task(0,"Android"), new Task(1,"Mac"), new Task(2, "Windows")};
		this.tasks = new ArrayList<>();
		Collections.addAll(this.tasks, tasks);
	}

	public Task get(int index) {
		return tasks.get(index);
	}

	public int count() {
		return tasks.size();
	}
}
