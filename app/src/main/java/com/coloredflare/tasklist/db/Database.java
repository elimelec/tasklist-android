package com.coloredflare.tasklist.db;

import java.util.ArrayList;

public interface Database {
	ArrayList<String> getAllLists();
	String[] getAllTasks(int listId);
	String getTask(int id);
	void addNewTask(String task);
	void deleteTask(int id);
}
