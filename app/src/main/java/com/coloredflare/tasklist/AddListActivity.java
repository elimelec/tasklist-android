package com.coloredflare.tasklist;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.coloredflare.tasklist.db.Database;
import com.coloredflare.tasklist.db.DatabaseFactory;
import com.coloredflare.tasklist.db.List;
import com.coloredflare.tasklist.db.Tasks;


public class AddListActivity extends ActionBarActivity {

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        id = getIntent().getExtras().getInt("newListId");
    }

    public void saveList(View view){

        EditText editText = (EditText) findViewById(R.id.new_list_name);
        String listName = editText.getText().toString();

        List list = new List(id, listName, new Tasks());
        Database database = DatabaseFactory.getDatabase(this);

        database.addList(list);

        super.onBackPressed();
    }

}
