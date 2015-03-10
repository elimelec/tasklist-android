package com.coloredflare.tasklist.db;

public class DB implements Database {

	private Lists lists;
	private Tasks tasks;

	public DB() {
		lists = new Lists();
		tasks = new Tasks();
	}

	@Override
	public Lists getLists() {
		return lists;
	}

	@Override
	public Tasks getTasks(List list) {
		return tasks;
	}
}
