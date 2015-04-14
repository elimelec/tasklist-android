package com.coloredflare.tasklist.db;

import android.content.Context;

public class DB implements Database {

	private Context context;
	private Lists lists;
	private Tasks tasks;

	public DB(Context context) {
		lists = new Lists();
		tasks = new Tasks();
		this.context = context;
	}

	@Override
	public Lists getLists() {
		return lists;
	}

    @Override
    public List getList(int id) {
        return null;
    }

	@Override
	public Tasks getTasks(int listId) {
		return tasks;
	}

	@Override
    public Task getTask(int id) {
        return null;
    }

    @Override
    public void deleteList(int listId) {

    }

    @Override
    public void deleteTask(int taskId) {

    }

    @Override
    public void addList(List list) {

    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void updateList(List list) {

    }

    @Override
    public void updateTask(Task task) {

    }
}
