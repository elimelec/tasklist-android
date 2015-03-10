package com.coloredflare.tasklist.db;

public class DB implements Database {

	private Lists lists;
	public DB() {
		lists = new Lists();
	}

	@Override
	public Lists getLists() {
		return lists;
	}

	@Override
	public Tasks getTasks(List list) {
		return null;
	}
}
