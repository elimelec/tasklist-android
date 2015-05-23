package com.coloredflare.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;
import com.coloredflare.tasklist.db.Tasks;


public class ListActivity extends ActionBarActivity {

    private Tasks tasks;
    private int listId;

    private boolean tapped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        updateTaskView();
    }

    public void addTask(View view){
        Intent intent = new Intent(ListActivity.this, AddTaskActivity.class);
        intent.putExtra("newTaskId", tasks.count());
        intent.putExtra("newListId", listId);
        startActivity(intent);

    }

    private void updateTaskView() {
        listId = (int) getIntent().getLongExtra("listId", -1);
        if (listId < 0){
            throw new RuntimeException("list id is negative");
        }

        ListView listView = (ListView) findViewById(R.id.listView);


        final Database database = DatabaseFactory.getDatabase(this);
        tasks = database.getTasks(listId);


        TaskAdapter adapter = new TaskAdapter(this, R.layout.list_simple_textview, tasks);

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
                               tapped = false;
                            }
                        }
                    }, 300);

                    tapped = true;
                }
                else {
                    Intent intent = new Intent(ListActivity.this, UpdateTaskActivity.class);
                    intent.putExtra("taskId", itemId);
                    intent.putExtra("listId", listId);
                    startActivity(intent);
                    tapped = false;
                }


            }
        };

        listView.setOnItemClickListener(listener);


        AdapterView.OnItemLongClickListener longClickListener = new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                database.deleteTask(listId, (int)id);
                updateTaskView();
                return true;
            }
        };

        listView.setOnItemLongClickListener(longClickListener);

    }

    @Override
    protected void onResume(){
        super.onResume();
        updateTaskView();
    }

}
