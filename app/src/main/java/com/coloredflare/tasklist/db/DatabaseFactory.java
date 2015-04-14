package com.coloredflare.tasklist.db;

import android.content.Context;

public class DatabaseFactory {

	public static Database getDatabase(Context context) {
		return new DB(context);
	}
}
