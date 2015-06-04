package com.coloredflare.tasklist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.coloredflare.tasklist.R;


public class Login extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void login(View view) {
		String username = getUsername();
		String password = getPassword();

		login(username, password);
	}

	private void login(String username, String password) {
		String token = "0da4cf2ddc459935cbbe5cc715848432";

		Intent items = new Intent(Login.this, Items.class);
		items.putExtra("token", token);
		startActivity(items);
	}

	private String getPassword() {
		TextView password = (TextView) findViewById(R.id.password);
		return password.getText().toString();
	}

	private String getUsername() {
		TextView username = (TextView) findViewById(R.id.username);
		return username.getText().toString();
	}
}
