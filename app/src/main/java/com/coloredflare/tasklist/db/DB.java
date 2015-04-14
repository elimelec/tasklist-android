package com.coloredflare.tasklist.db;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DB implements Database {

	private final Context context;
	private Lists lists;
	private final Tasks tasks;
	private File database;

	public DB(Context context) {
		tasks = new Tasks();
		this.context = context;
		openOrCreateFile();
	}

	private void openOrCreateFile() {
		openFile();
		createFileIfNecessary();
	}

	private void createFileIfNecessary() {
		if (!database.exists()) {
			try {
			final boolean fileCreated = database.createNewFile();
			if (!fileCreated)
				throw new IOException();
		} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void openFile() {
		File path = context.getFilesDir();
		String filename = "database.txt";
		database = new File(path, filename);
	}

	@Override
	public Lists getLists() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(database));
			readLists(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lists;
	}

	private void readLists(BufferedReader reader) {
		try {
			int numberOfLists;
			String numberOfListsString = reader.readLine();
			numberOfLists = numberOfListsString == null ? 0 : Integer.parseInt(numberOfListsString);
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
		lists = lists.add(list);
		writeLists();
    }

	private void writeLists() {
		database.delete();
		createFileIfNecessary();

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(database));

			writer.append("" + lists.count());
			writer.newLine();

			for (int i = 0; i < lists.count(); i++) {
				writer.append(lists.get(i).toString());
				writer.newLine();
			}

			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
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
