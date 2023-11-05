package com.backink.beetlerecord.project;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;

import com.backink.beetlerecord.Project;
import com.backink.beetlerecord.ProjectDao;

import java.util.List;

public class ProjectViewModel extends ViewModel {
    private LiveData<List<Project>> projects;
    private ProjectDao dao;

    public ProjectViewModel(Application application, ProjectDao dao) {
        this.dao = dao;
        projects = this.dao.loadAll();
    }

    public LiveData<List<Project>> getProjects() {
        return projects;
    }

    public void insert(Project project) {
        new Thread(() -> dao.insert(project)).start();
    }
}
