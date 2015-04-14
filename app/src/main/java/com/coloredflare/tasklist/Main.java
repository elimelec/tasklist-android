package com.coloredflare.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;
import com.coloredflare.tasklist.db.Lists;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView listView = (ListView) findViewById(R.id.listView);


		Database database = DatabaseFactory.getDatabase(this);
		final Lists values = database.getLists();


        ListAdapter adapter = new ListAdapter(this, R.layout.list_simple_textview, values);

        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Main.this, ListActivity.class);
                intent.putExtra("listId", id);
                startActivity(intent);

            }
        };

        listView.setOnItemClickListener(listener);

    }

}
