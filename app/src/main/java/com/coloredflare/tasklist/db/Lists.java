package com.coloredflare.tasklist.db;

import java.util.ArrayList;
import java.util.Collections;

public class Lists extends ArrayList <List> {

	public Lists() {
		List[] lists = new List[] { new List(0,"Android"), new List(1,"Mac"), new List(2, "Windows")};
		Collections.addAll(this, lists);
	}

	@Override
	public List get(int index) {
		return super.get(index);
	}
}
