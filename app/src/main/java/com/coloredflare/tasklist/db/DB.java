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
    public List getList(int id) {
        return null;
    }

    @Override
	public Tasks getTasks(List list) {
		return tasks;
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
    public void deleteList(List list) {

    }

    @Override
    public void deleteTask(Task task) {

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
