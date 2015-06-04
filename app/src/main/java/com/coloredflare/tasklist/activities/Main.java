package com.coloredflare.tasklist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.coloredflare.tasklist.R;


public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void addList(View view){
        Intent intent = new Intent(Main.this, AddListActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onResume(){
        super.onResume();
    }

}
