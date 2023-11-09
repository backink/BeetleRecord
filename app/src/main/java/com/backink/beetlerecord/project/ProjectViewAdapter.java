package com.backink.beetlerecord.project;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.backink.beetlerecord.Project;
import com.backink.beetlerecord.R;

import java.util.List;

public class ProjectViewAdapter extends ListAdapter<Project, ProjectViewAdapter.ProjectViewHolder> {

    protected ProjectViewAdapter(@NonNull DiffUtil.ItemCallback<Project> diffCallback) {
        super(diffCallback);
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        private final TextView projectName;
        private final TextView createDate;

        public ProjectViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            projectName = view.findViewById(R.id.project_name);
            createDate = view.findViewById(R.id.created_date);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.project_recycler, viewGroup, false);

        return new ProjectViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ProjectViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.projectName.setText(getItem(position).projectName);
        viewHolder.createDate.setText("Created : " + getItem(position).createDate);
        viewHolder.itemView.setOnClickListener(view -> {
            Toast.makeText(viewHolder.itemView.getContext(), viewHolder.projectName.getText(), Toast.LENGTH_LONG).show();
        });
    }

    public static class ProjectDiffCallback extends DiffUtil.ItemCallback<Project> {

        @Override
        public boolean areItemsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
            return oldItem.projectName.equals(newItem.projectName);
        }
    }
}