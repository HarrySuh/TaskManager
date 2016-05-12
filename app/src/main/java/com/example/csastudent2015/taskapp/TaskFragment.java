package com.example.csastudent2015.taskapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by csastudent2015 on 4/14/16.
 */
public class TaskFragment extends Fragment {
    private EditText taskName;
    private EditText taskDescription;
    private String text;
    private Button create;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putCharSequence(text, taskName.getText().toString());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_task, container, false);


        taskName = (EditText) rootView.findViewById(R.id.taskName);
        taskDescription = (EditText) rootView.findViewById(R.id.taskDescription);
        create = (Button) rootView.findViewById(R.id.createButton);

        if(savedInstanceState != null) {
            taskName.setText(savedInstanceState.getCharSequence(text));
            taskDescription.setText(savedInstanceState.getCharSequence(text));
        }

        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click



                }
        });

        return rootView;
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
