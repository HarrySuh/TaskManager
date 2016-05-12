package com.example.csastudent2015.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by csastudent2015 on 4/20/16.
 */
public class TaskListFragment extends Fragment {
    private TextView taskName;
    private TextView task1;
    private TextView task2;
    private TextView task3;
    private TextView task4;
    private TextView task5;
    private TextView task6;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_task_list, container, false);

        task1 = (TextView) rootView.findViewById(R.id.textView1);
        task2 = (TextView) rootView.findViewById(R.id.textView2);
        task3 = (TextView) rootView.findViewById(R.id.textView3);
        task5= (TextView) rootView.findViewById(R.id.textView5);
        task6 = (TextView) rootView.findViewById(R.id.textView6);

        task1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent myIntent = new Intent(getActivity(), TaskActivity.class);
                getActivity().startActivity(myIntent);

            }
        });

        if(savedInstanceState != null) {

        }


        return rootView;
    }

    public void changeText(String text, TextView task)
    {
        task.setText(text);
    }
}
