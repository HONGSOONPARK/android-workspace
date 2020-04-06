package com.stepup.mvp_std01.main;

import com.stepup.mvp_std01.model.TaskRepository;
import com.stepup.mvp_std01.model.domain.Task;

public class MainPresenter {

    private MainFragment view;

    public void attachView(MainFragment mainFragment){
        this.view = mainFragment;
    }

    public void loadTask(){

        Task task = TaskRepository.getInstance().getTask(1);
        String titleToShow = task.getTitle() +"입니다 mvp";
        ///...

        view.setTaskTitle(titleToShow);


    };




}
