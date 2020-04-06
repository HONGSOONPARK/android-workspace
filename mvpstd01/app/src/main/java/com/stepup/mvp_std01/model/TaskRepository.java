package com.stepup.mvp_std01.model;

import java.util.HashMap;

public class TaskRepository {

    private static TaskRepository instance;
    private HashMap<Integer, Task> tasks = new HashMap<>();

    private TaskRepository(){

    }

    public static TaskRepository getInstance() {
        if(null == instance){
            instance = new TaskRepository();
        }
        return instance;
    }


    public void insert(){

    }

    public Task getTask(int id){
        Task task = new Task();
        task.setTitle("tititititile");
        task.setContents("concocococococntents");
        return task;
    }


}
