package com.stepup.mvp_std01.main;

import com.stepup.mvp_std01.model.domain.Task;

public interface iTaskRepository {

    Task getTask(int id);

}
