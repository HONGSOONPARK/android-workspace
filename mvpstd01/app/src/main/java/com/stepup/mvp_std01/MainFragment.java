package com.stepup.mvp_std01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stepup.mvp_std01.model.Task;
import com.stepup.mvp_std01.model.TaskRepository;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        TextView testview_title = rootView.findViewById(R.id.textView_title);

        Task task = TaskRepository.getInstance().getTask(1);
        String titleToShow = task.getTitle() + "입니다 ";

        testview_title.setText(titleToShow);

        return rootView;
    }
}
