package com.coloredflare.tasklist.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.coloredflare.tasklist.R;
import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;
import com.coloredflare.tasklist.datatypes.Task;

public class AddTaskActivity extends ActionBarActivity {

    private int id;
    private int listId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        id = getIntent().getIntExtra("newTaskId", -1);
        listId = getIntent().getIntExtra("newListId", -1);

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

        Task task = new Task(id, taskName, false);
        Database database = DatabaseFactory.getDatabase(this);

        database.addTask(task, listId);

        super.onBackPressed();
    }
}
