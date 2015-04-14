package com.coloredflare.tasklist.db;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DB implements Database {

	private Context context;
	private Lists lists;
	private Tasks tasks;
	private File database;

	public DB(Context context) {
		tasks = new Tasks();
		this.context = context;
		openFile();
	}

	private void openFile() {
		File path = context.getFilesDir();
		String filename = "database.txt";
		database = new File(path, filename);
		if (!database.exists()) {
			try {
				database.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Lists getLists() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(database));
			try {
				int numberOfLists = Integer.parseInt(reader.readLine());
				ArrayList<List> lists = new ArrayList<>();
				for (int i = 0; i < numberOfLists; i++){
					String listName = reader.readLine();
					List list = new List(i, listName);
					lists.add(list);
				}
				this.lists = new Lists(lists);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
