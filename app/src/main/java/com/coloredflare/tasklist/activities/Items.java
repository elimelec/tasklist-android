package com.coloredflare.tasklist.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.coloredflare.tasklist.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Items extends ActionBarActivity {

	private String token;
	private String itemsJSON;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		token = getToken();

		Log.d(token, token);
		new Thread(new Runnable() {
			@Override
			public void run() {
				String s = "";
				try {
					s = read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				itemsJSON = s;
				doneRead();
			}
		}).start();

		setContentView(R.layout.items);
	}

	private String getToken() {
		return getIntent().getStringExtra("token");
	}

	private void doneRead() {
		Log.d("", itemsJSON);

		JSONArray a;
		try {
			a = new JSONArray(itemsJSON);
			a.getJSONObject(0).toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private String read() throws IOException {
		URL oracle = new URL("http://10.0.3.2/api/items/0/" + token);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(oracle.openStream()));

		String inputLine;
		inputLine = in.readLine();
		in.close();

		return inputLine;
	}

}
