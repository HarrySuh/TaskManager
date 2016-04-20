package com.example.csastudent2015.taskapp;

/**
 * Created by csastudent2015 on 4/12/16.
 */
public class TaskActivity {
    public String taskName;
    public String taskDescription;

    public TaskActivity(String name, String description)
    {
        taskName = name;
        taskDescription = description;
    }

    public TaskActivity(String name)
    {
        taskName = name;
    }

    public void editDescription(String description)
    {
        taskDescription = description;
    }
}
