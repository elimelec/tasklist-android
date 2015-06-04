package com.coloredflare.tasklist.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coloredflare.tasklist.R;
import com.coloredflare.tasklist.adapters.ItemAdapter;
import com.coloredflare.tasklist.datatypes.Item;
import com.coloredflare.tasklist.datatypes.Items;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ItemsActivity extends ActionBarActivity {

	private String base_url;
	private Items items = new Items();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		base_url = getUrl();
		Log.d(base_url, base_url);
		readNewThread(base_url);
		setContentView(R.layout.items);
	}

	private void itemsUpdated() {
		ListView listView = (ListView) findViewById(R.id.listView);

		ItemAdapter adapter = new ItemAdapter(this, R.layout.list_simple_textview, items);
		listView.setAdapter(adapter);

		AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				/// perform action
				Log.d("action: ", "" + items.items.get(position).action);
			}
		};
		AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				/// perform delete
				Log.d("delete: ", "" + items.items.get(position).delete);
				return true;
			}
		};

		listView.setOnItemClickListener(listener);
		listView.setOnItemLongClickListener(longClickListener);
	}

	private void readNewThread(final String url) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String s;
				s = read(url);
				doneRead(s);
			}
		}).start();
	}

	private String getUrl() {
		return getIntent().getStringExtra("items_url");
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

	private String read(String url) {
		String itemsUrl = "http://10.0.3.2/api" + url;
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
