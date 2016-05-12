package com.example.csastudent2015.taskapp;

/**
 * Created by csastudent2015 on 4/12/16.
 */
public class Task {
    public String taskName;
    public String taskDescription;

    public Task(String name, String description)
    {
        taskName = name;
        taskDescription = description;
    }

    public Task(String name)
    {
        taskName = name;
    }

    public void editDescription(String description)
    {
        taskDescription = description;
    }
}
