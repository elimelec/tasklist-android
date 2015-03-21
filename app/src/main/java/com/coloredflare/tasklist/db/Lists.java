package com.coloredflare.tasklist.db;

import java.util.ArrayList;
import java.util.Collections;

public class Lists {
    ArrayList<List> lists;

	public Lists() {
		List[] lists = new List[] { new List(0,"Android"), new List(1,"Mac"), new List(2, "Windows")};
        this.lists = new ArrayList<>();
		Collections.addAll(this.lists, lists);
	}

	public List get(int index) {
		return lists.get(index);
	}

    public int count() {
        return lists.size();
    }
}
