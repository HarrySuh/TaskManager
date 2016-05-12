package com.example.csastudent2015.taskapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by csastudent2015 on 4/26/16.
 */
public class TaskListActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag("TaskListFragment") == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.content_frame, new TaskListFragment(), "TaskListFragment")
                    .commit();
        }

    }
}

