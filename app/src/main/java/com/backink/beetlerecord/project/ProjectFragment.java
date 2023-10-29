package com.backink.beetlerecord.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.RoomDatabase;

import com.backink.beetlerecord.AppDatabase;
import com.backink.beetlerecord.R;
import com.backink.beetlerecord.databinding.FragmentProjectBinding;
public class ProjectFragment extends Fragment {

    private FragmentProjectBinding binding;
    private AppDatabase database;
    private ProjectViewAdapter viewAdapter;
    private ProjectViewModel viewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentProjectBinding.inflate(inflater, container, false);

        database = AppDatabase.getInstance(getContext());
        viewModel = new ViewModelProvider(this, new ProjectViewModelFactory(database.projectDao())).get(ProjectViewModel.class);
        viewAdapter = new ProjectViewAdapter();
        binding.projectRecycler.setAdapter(viewAdapter);
        binding.projectRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}