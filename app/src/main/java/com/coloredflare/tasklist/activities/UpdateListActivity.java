package com.coloredflare.tasklist.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.coloredflare.tasklist.R;
import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;

public class UpdateListActivity extends ActionBarActivity {

    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_list);

        id = getIntent().getExtras().getLong("listId");
    }

    public void saveList(View view){

        EditText editText = (EditText) findViewById(R.id.new_list_name);
        String listName = editText.getText().toString();

        Database database = DatabaseFactory.getDatabase(this);
        database.updateList((int)id, listName);

        super.onBackPressed();
    }

}
