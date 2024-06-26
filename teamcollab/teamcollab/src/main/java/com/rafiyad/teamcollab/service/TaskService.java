package com.rafiyad.teamcollab.service;

import com.rafiyad.teamcollab.model.Project;
import com.rafiyad.teamcollab.model.Task;
import com.rafiyad.teamcollab.model.User;
import com.rafiyad.teamcollab.repo.ProjectRepo;
import com.rafiyad.teamcollab.repo.TaskRepo;
import com.rafiyad.teamcollab.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepository;

    @Autowired
    private ProjectRepo projectRepository;

    @Autowired
    private UserRepo userRepository;

    public void createTask(String title, String description, String status, String priority,
                           Long projectId, Long assignedToId, LocalDateTime dueDate) {
        // Find the project
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        // Find the assigned user (if assignedToId is not null)
        User assignedTo = null;
        if (assignedToId != null) {
            assignedTo = userRepository.findById(assignedToId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
        }

        // Create a new Task instance
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setPriority(priority);
        task.setProject(project);
        task.setAssignedTo(assignedTo);
        task.setDue_date(dueDate);

        // Save the task
        taskRepository.save(task);
    }
}
