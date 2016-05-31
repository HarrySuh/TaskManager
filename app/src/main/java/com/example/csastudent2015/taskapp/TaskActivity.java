package com.example.csastudent2015.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by csastudent2015 on 4/26/16.
 */
public class TaskActivity extends AppCompatActivity{
    private EditText taskName;
    private EditText taskDescription;
    private Button create;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_task);

        taskName = (EditText) findViewById(R.id.taskName);
        taskDescription = (EditText) findViewById(R.id.taskDescription);
        create = (Button) findViewById(R.id.createButton);

        if(savedInstanceState != null) {
//            taskName.setText(savedInstanceState.getCharSequence(text));
//            taskDescription.setText(savedInstanceState.getCharSequence(text));
        }

        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Task task = new Task(taskName.toString(), taskDescription.toString());
                taskName.setText(task.getNewName());
                taskDescription.setText(task.getDescription());
                Log.e("BUTTON: ", "SAVE CLICKED ");
                finish();
            }
        });

    }
    public String getTaskName()
    {
        return taskName.toString();
    }

    public String getTaskDescription()
    {
        return taskDescription.toString();
    }
}


