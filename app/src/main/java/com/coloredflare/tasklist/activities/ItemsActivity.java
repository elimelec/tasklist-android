package com.coloredflare.tasklist.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.coloredflare.tasklist.R;
import com.coloredflare.tasklist.datatypes.Item;
import com.coloredflare.tasklist.datatypes.Items;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ItemsActivity extends ActionBarActivity {

	private String token;
	private Items items = new Items();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		token = getToken();
		Log.d(token, token);
		readItems(0);
		setContentView(R.layout.items);
	}

	private void itemsUpdated() {
		for(Item item : items.items) {
			Log.d(item.name, item.action);
		}
	}

	private void readItems(final int parent) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String s;
				s = read(parent);
				doneRead(s);
			}
		}).start();
	}

	private String getToken() {
		return getIntent().getStringExtra("token");
	}

	private void doneRead(String itemsJSON) {
		JSONArray a;
		try {
			a = new JSONArray(itemsJSON);
			Items items = new Items();

			int itemsCount = a.length();
			for (int i = 0; i < itemsCount; i++) {
				items.items.add(Item.fromJSON(a.getJSONObject(i)));
			}
			this.items = items;
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					itemsUpdated();
				}
			});
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	private String read(int parent) {
		String itemsUrl = "http://10.0.3.2/api/items/" + parent + "/" + token;
		String inputLine = "";

		try {
			BufferedReader in = null;
			URL oracle = new URL(itemsUrl);
			in = new BufferedReader(
					new InputStreamReader(oracle.openStream()));
			inputLine += in.readLine();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return inputLine;
	}

}
