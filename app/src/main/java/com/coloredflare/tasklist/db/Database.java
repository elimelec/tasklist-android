package com.coloredflare.tasklist.db;

public interface Database {
	Lists getLists();
    List getList(int id);

	Tasks getTasks(int listId);
    Task getTask(int id);

    void deleteList(int listId);
    void deleteTask(int taskId);

    void addList(List list);
    void addTask(Task task);

    void updateList(List list);
    void updateTask(Task task);
}
