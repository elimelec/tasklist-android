package com.coloredflare.tasklist.db;

public interface Database {
	Lists getLists();
	Tasks getTasks(List list);
}
