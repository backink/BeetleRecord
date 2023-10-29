package com.backink.beetlerecord.project;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.backink.beetlerecord.ProjectDao;

public class ProjectViewModelFactory implements ViewModelProvider.Factory {
    private Application application;
    private final ProjectDao dao;

    public ProjectViewModelFactory(ProjectDao dao) {
        this.dao = dao;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new ProjectViewModel(application, dao);
    }
}
