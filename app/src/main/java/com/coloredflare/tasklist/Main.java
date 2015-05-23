package com.coloredflare.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;
import com.coloredflare.tasklist.db.Lists;
import com.coloredflare.tasklist.db.UpdateListActivity;


public class Main extends ActionBarActivity {

    private Lists lists;
    private boolean tapped = false;

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


        final Database database = DatabaseFactory.getDatabase(this);
        lists = database.getLists();


        ListAdapter adapter = new ListAdapter(this, R.layout.list_simple_textview, lists);

        listView.setAdapter(adapter);


        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final long itemId = id;

                //checks if double tapped
                if (!tapped) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (tapped) {
                                // show task
                                Intent intent = new Intent(Main.this, ListActivity.class);
                                intent.putExtra("listId", itemId);
                                startActivity(intent);
                                tapped = false;
                            }
                        }
                    }, 300);

                    tapped = true;
                }
                else {
                    Intent intent = new Intent(Main.this, UpdateListActivity.class);
                    intent.putExtra("listId", itemId);
                    startActivity(intent);
                    tapped = false;
                }


            }
        };

        listView.setOnItemClickListener(listener);

        AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                database.deleteList((int)id);
                updateListView();
                return true;
            }
        };

        listView.setOnItemLongClickListener(longClickListener);
    }

}
