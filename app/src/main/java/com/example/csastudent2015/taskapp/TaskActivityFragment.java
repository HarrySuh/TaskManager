package com.example.csastudent2015.taskapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by csastudent2015 on 4/20/16.
 */
public class TaskActivityFragment extends Fragment {
    private TextView taskName;
    private Button members;
    private TextView task1;
    private CheckBox check1;
    private TextView task2;
    private CheckBox check2;
    private TextView task3;
    private CheckBox check3;
    private TextView task4;
    private CheckBox check4;
    private TextView task5;
    private CheckBox check5;
    private TextView task6;
    private CheckBox check6;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_task, container, false);

        taskName = (TextView) rootView.findViewById(R.id.taskNameTextView);
        members = (Button) rootView.findViewById(R.id.membersButton);
        task1 = (TextView) rootView.findViewById(R.id.textView1);
        check1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
        task2 = (TextView) rootView.findViewById(R.id.textView2);
        check2 = (CheckBox) rootView.findViewById(R.id.checkBox2);
        task3 = (TextView) rootView.findViewById(R.id.textView3);
        check4 = (CheckBox) rootView.findViewById(R.id.checkBox4);
        task5= (TextView) rootView.findViewById(R.id.textView5);
        check5 = (CheckBox) rootView.findViewById(R.id.checkBox5);
        task6 = (TextView) rootView.findViewById(R.id.textView6);
        check6 = (CheckBox) rootView.findViewById(R.id.checkBox6);

        return rootView;
    }
}
