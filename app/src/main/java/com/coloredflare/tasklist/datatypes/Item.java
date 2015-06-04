package com.coloredflare.tasklist.datatypes;

import org.json.JSONException;
import org.json.JSONObject;

public class Item {
	public String name = "";
	public int id = 0;
	public String type = "";
	public String action = "";
	public String delete = "";

	public static Item fromJSON(JSONObject json) {
		Item item = new Item();
		try {
			item.name = json.getString("name");
			item.id = json.getInt("id");
			item.type = json.getString("type");
			item.action = json.getString("action");
			item.delete = json.getString("delete");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return item;
	}
}
