package com.coloredflare.tasklist.db;

import java.util.ArrayList;

public class Tasks {
	private final ArrayList<Task> tasks;

    public Tasks() {
		tasks = new ArrayList<>();
	}

	public Tasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public Task get(int index) {
		return tasks.get(index);
	}

	public int count() {
		return tasks.size();
	}

	public Tasks add(Task task) {
		ArrayList<Task> tasksCopy = new ArrayList<>(this.tasks);
		tasksCopy.add(task);
		return new Tasks(tasksCopy);
	}


    public Tasks replace(Task task) {
        ArrayList<Task> tasksCopy = new ArrayList<>(this.tasks);
        tasksCopy.remove(task.getId());
        tasksCopy.add(task.getId(), task);
        return new Tasks(tasksCopy);
    }

    public Tasks remove(int id) {
        tasks.remove(id);
        return this;
    }
}
