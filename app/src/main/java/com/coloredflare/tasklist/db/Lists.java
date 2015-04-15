package com.coloredflare.tasklist.db;

import java.util.ArrayList;

public class Lists {
    private final ArrayList<List> lists;

	public Lists() {
		lists = new ArrayList<>();
	}

	public Lists(ArrayList<List> lists) {
        this.lists = lists;
	}

	public List get(int index) {
		return lists.get(index);
	}

    public int count() {
        return lists.size();
    }

	public Lists add(List list) {
		ArrayList<List> listsCopy = new ArrayList<>(this.lists);
		listsCopy.add(list);
		return new Lists(listsCopy);
	}
}
