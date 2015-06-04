package com.coloredflare.tasklist.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.coloredflare.tasklist.R;


public class Main extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void addList(View view) {
		String username = getUsername();
		String password = getPassword();

		getLoginToken(username, password);
		//Intent intent = new Intent(Main.this, AddListActivity.class);
		//startActivity(intent);
	}

	private String getLoginToken(String username, String password) {
		return "0da4cf2ddc459935cbbe5cc715848432";
	}

	private String getPassword() {
		TextView password = (TextView) findViewById(R.id.password);
		return password.getText().toString();
	}

	private String getUsername() {
		TextView username = (TextView) findViewById(R.id.username);
		return username.getText().toString();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
