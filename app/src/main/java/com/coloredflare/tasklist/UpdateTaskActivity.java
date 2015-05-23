package com.coloredflare.tasklist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;


public class UpdateTaskActivity extends ActionBarActivity {

    private long id;
    private int listId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);

        id = getIntent().getLongExtra("taskId", -1);
        listId = getIntent().getIntExtra("listId", -1);

        if (listId < 0){
            throw new RuntimeException("list id is negative");
        }
        if (id < 0){
            throw new RuntimeException("task id is negative");
        }

    }

    public void saveTask(View view){

//        int taskId = (int) getIntent().getLongExtra("taskId", 0);

        EditText editText = (EditText) findViewById(R.id.new_task_name);
        String taskName = editText.getText().toString();

        Database database = DatabaseFactory.getDatabase(this);
        database.updateTask(listId, (int)id, taskName);

        super.onBackPressed();
    }
}
