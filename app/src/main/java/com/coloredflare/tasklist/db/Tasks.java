package com.coloredflare.tasklist.db;

import java.util.ArrayList;
import java.util.Collections;

public class Tasks extends ArrayList <Task> {

	public Tasks() {
		Task[] tasks = new Task[] { new Task(0,"Android"), new Task(1,"Mac"), new Task(2, "Windows")};
		Collections.addAll(this, tasks);
	}
}
