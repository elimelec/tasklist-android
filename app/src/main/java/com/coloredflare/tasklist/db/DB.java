package com.coloredflare.tasklist.db;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DB implements Database {

	private final Context context;
	static private Lists lists;
	private File database;

	public DB(Context context) {
		this.context = context;
		openOrCreateFile();
		readDatabase();
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
		return lists;
	}


	private void readDatabase() {
		BufferedReader bufferedReader;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(database);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("exception!!!!!");
		}
		bufferedReader = new BufferedReader(fileReader);


		int numberOfLists;
		try {
			numberOfLists = Integer.parseInt(bufferedReader.readLine());
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("exception!!!!!");
		}

		Lists lists = new Lists();

		for (int i = 0; i < numberOfLists; i++) {
			String listName;
			try {
				listName = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("exception!!!!!");
			}


			int numberOfTasks;
			try {
				numberOfTasks = Integer.parseInt(bufferedReader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("exception!!!!!");
			}

			Tasks tasks = new Tasks();
			for (int j = 0; j < numberOfTasks; j++) {

				String taskName = null;
				boolean checked;
				try {
					taskName = bufferedReader.readLine();
					checked = Boolean.parseBoolean(bufferedReader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException("exception!!!!!");
				}


				Task task = new Task(j, taskName, checked);
				tasks = tasks.add(task);
			}

			List list = new List(i, listName, tasks);
			lists = lists.add(list);
		}

		DB.lists = lists;
	}


	@Override
    public List getList(int id) {
        return lists.get(id);
    }

	@Override
	public Tasks getTasks(int listId) {
		return lists.get(listId).getTasks();
	}

	@Override
    public Task getTask(int id) {
        return null;
    }

    @Override
    public void deleteList(int listId) {
        lists.remove(listId);
        writeDatabase();

    }

    @Override
    public void deleteTask(int listId, int taskId) {
        lists.get(listId).getTasks().remove(taskId);
        writeDatabase();
    }

    @Override
    public void addList(List list) {
		lists = lists.add(list);
		writeDatabase();
    }

	@Override
	public void addTask(Task task, int listId) {
		List list = lists.get(listId);
		list = new List(list.getId(), list.toString(), list.getTasks().add(task));
		lists = lists.replace(list);
		writeDatabase();
	}

	private void writeDatabase() {
		database.delete();
		createFileIfNecessary();

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(database));

			writer.append("" + lists.count());
			writer.newLine();

			for (int i = 0; i < lists.count(); i++) {
				List list = lists.get(i);

				writer.append(list.toString());
				writer.newLine();

				Tasks tasks = list.getTasks();
				writer.append("" + tasks.count());
				writer.newLine();

				for (int j = 0; j < tasks.count(); j++) {
					Task task = tasks.get(j);
					writer.append(task.toString());
					writer.newLine();
					writer.append("" + task.isChecked());
					writer.newLine();
				}

			}

			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @Override
    public void updateList(int listId, String listName) {
        List list = lists.get(listId);
        lists = lists.replace(new List(listId, listName, list.getTasks()));
        writeDatabase();
    }

    @Override
    public void updateTask(int listId, int taskId, String taskName) {

        List list = lists.get(listId);

		Task task = lists.get(listId).getTasks().get(taskId);
		task =  new Task(task.getId(), taskName, task.isChecked());

		list = new List(list.getId(), list.toString(), list.getTasks().replace(task));
        lists = lists.replace(list);

        writeDatabase();
    }

	@Override
	public void checkTask(int listId, int taskId) {
		Task task = lists.get(listId).getTasks().get(taskId);
		task =  new Task(task.getId(), task.toString(), !task.isChecked());
		List list = lists.get(listId);
		list = new List(list.getId(), list.toString(), list.getTasks().replace(task));
		lists = lists.replace(list);
		writeDatabase();
	}
}
