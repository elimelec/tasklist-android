package com.coloredflare.tasklist.db;

import com.coloredflare.tasklist.datatypes.List;
import com.coloredflare.tasklist.datatypes.Lists;
import com.coloredflare.tasklist.datatypes.Task;
import com.coloredflare.tasklist.datatypes.Tasks;

public interface Database {
	Lists getLists();

    Tasks getTasks(int listId);

    void deleteList(int listId);
    void deleteTask(int listId, int taskId);

    void addList(List list);
    void addTask(Task task, int listId);

    void updateList(int listId, String listName);
    void updateTask(int listId, int taskId, String taskName);
    void checkTask(int listId, int taskId);
}
