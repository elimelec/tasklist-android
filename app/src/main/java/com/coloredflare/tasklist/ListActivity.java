package com.coloredflare.tasklist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;
import com.coloredflare.tasklist.db.Lists;
import com.coloredflare.tasklist.db.Task;
import com.coloredflare.tasklist.db.Tasks;


public class ListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        int listId = getIntent().getExtras().getInt("listId");

        ListView listView = (ListView) findViewById(R.id.listView);


        Database database = DatabaseFactory.getDatabase();
        final Tasks values = database.getTasks(listId);


        TaskAdapter adapter = new TaskAdapter(this, R.layout.list_simple_textview, values);

        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        };

        listView.setOnItemClickListener(listener);
    }



}
