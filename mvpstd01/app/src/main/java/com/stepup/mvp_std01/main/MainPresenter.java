package com.stepup.mvp_std01.main;

import com.stepup.mvp_std01.model.TaskRepository;
import com.stepup.mvp_std01.model.domain.Task;

public class MainPresenter {

    private iView view;
    private iTaskRepository taskRepository;

    public void attachView(iView view){
        this.view = view;
        this.taskRepository = TaskRepository.getInstance();
    }

    public void loadTask(){
        Task task = taskRepository.getTask(1);
        String titleToShow = task.getTitle() +"입니다 mvp";
        ///...
        view.setTaskTitle(titleToShow);
    };





}
