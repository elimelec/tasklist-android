package com.coloredflare.tasklist.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.coloredflare.tasklist.R;

public class Items extends ActionBarActivity {

	private String token;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		token = getToken();

		setContentView(R.layout.items);
	}

	private String getToken() {
		return getIntent().getStringExtra("token");
	}

	private String getItems() {
		return getString(R.string.test_items);
	}

}
