package com.coloredflare.tasklist.db;

public class DatabaseFactory {

	public static Database getDatabase() {
		return new TestDatabse();
	}
}
