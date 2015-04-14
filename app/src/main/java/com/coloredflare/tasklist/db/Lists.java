package com.coloredflare.tasklist.db;

import java.util.ArrayList;

public class Lists {
    ArrayList<List> lists;

	public Lists(ArrayList<List> lists) {
        this.lists = lists;
	}

	public List get(int index) {
		return lists.get(index);
	}

    public int count() {
        return lists.size();
    }
}
