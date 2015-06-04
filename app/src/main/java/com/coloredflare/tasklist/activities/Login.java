package com.coloredflare.tasklist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.coloredflare.tasklist.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class Login extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void login(View view) {
		String username = getUsername();
		String password = getPassword();

		loginAndStartActivity(username, password);
	}

	private String getPassword() {
		TextView password = (TextView) findViewById(R.id.password);
		return password.getText().toString();
	}

	private String getUsername() {
		TextView username = (TextView) findViewById(R.id.username);
		return username.getText().toString();
	}

	private void loginAndStartActivity(final String username, final String password) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				final String token;
				try {
					token = read(username, password);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							startActivity(token);
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void startActivity(String token) {
		if (token == null)
			return;

		Intent items = new Intent(Login.this, Items.class);
		items.putExtra("token", token);
		startActivity(items);
	}

	private String read(String username, String password) throws IOException {
		URL oracle = new URL("http://10.0.3.2/api/login/" + username + "/" + password);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(oracle.openStream()));

		String inputLine;
		inputLine = in.readLine();
		in.close();

		return inputLine;
	}
}
