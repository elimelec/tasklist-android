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

    private Lists lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        updateListView();

    }

    public void addList(View view){
        Intent intent = new Intent(Main.this, AddListActivity.class);
        intent.putExtra("newListId", lists.count());
        startActivity(intent);

    }

    @Override
    protected void onResume(){
        super.onResume();
        updateListView();
    }

    private void updateListView() {
        ListView listView = (ListView) findViewById(R.id.listView);


        Database database = DatabaseFactory.getDatabase(this);
        lists = database.getLists();


        ListAdapter adapter = new ListAdapter(this, R.layout.list_simple_textview, lists);

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
