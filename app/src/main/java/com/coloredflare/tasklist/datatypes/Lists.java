package com.coloredflare.tasklist.datatypes;

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

	public Lists replace(List list) {
		ArrayList<List> listsCopy = new ArrayList<>(this.lists);
		listsCopy.remove(list.getId());
		listsCopy.add(list.getId(), list);
		return new Lists(listsCopy);
	}

    public Lists remove(int id) {
        lists.remove(id);
        return this;
    }

}
