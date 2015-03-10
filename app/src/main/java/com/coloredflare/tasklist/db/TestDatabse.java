package com.coloredflare.tasklist.db;

import java.util.ArrayList;
import java.util.Collections;

public class TestDatabse implements Database {

	ArrayList<String> lists;

	public TestDatabse() {
		lists = new ArrayList<>();
		String[] strings = new String[] { "Android", "iPhone", "WindowsMobile",
				"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
				"Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
				"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
				"Android", "iPhone", "WindowsMobile" };
		Collections.addAll(lists, strings);
	}

	@Override
	public ArrayList<String> getAllLists() {
		return lists;
	}

	@Override
	public String[] getAllTasks(int listId) {
		return new String[0];
	}

	@Override
	public String getTask(int id) {
		return null;
	}

	@Override
	public void addNewTask(String task) {
		lists.add(task);
	}

	@Override
	public void deleteTask(int id) {

	}
}
