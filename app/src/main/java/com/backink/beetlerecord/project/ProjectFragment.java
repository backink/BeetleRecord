package com.backink.beetlerecord.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.RoomDatabase;

import com.backink.beetlerecord.AppDatabase;
import com.backink.beetlerecord.Project;
import com.backink.beetlerecord.R;
import com.backink.beetlerecord.databinding.FragmentProjectBinding;

import java.util.List;

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
        viewAdapter = new ProjectViewAdapter(new ProjectViewAdapter.ProjectDiffCallback());
        binding.projectRecycler.setAdapter(viewAdapter);

        viewModel.getProjects().observe(getViewLifecycleOwner(), new Observer<List<Project>>() {
            @Override
            public void onChanged(List<Project> projects) {
                viewAdapter.submitList(projects);
            }
        });

        binding.fabProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = createDialog();
                dialog.show();
            }
        });

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

    private AlertDialog createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.project_dialog, null);
        builder.setView(dialogView);
        builder.setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText input = dialogView.findViewById(R.id.input_project_name);
                viewModel.insert(new Project(input.getText().toString()));
            }
        });
        builder.setNegativeButton(R.string.cancel, null);

        return builder.create();
    }

}