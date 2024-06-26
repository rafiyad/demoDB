package com.rafiyad.teamcollab.controller;

import com.rafiyad.teamcollab.model.Project;
import com.rafiyad.teamcollab.model.Task;
import com.rafiyad.teamcollab.repo.ProjectRepo;
import com.rafiyad.teamcollab.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskRepo taskRepository;

    @Autowired
    private ProjectRepo projectRepository;

    // Retrieve a list of all tasks in a project
    @GetMapping("/projects/{project_id}/tasks")
    public ResponseEntity<List<Task>> getAllTasksInProject(@PathVariable("project_id") Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (!projectOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Task> tasks = taskRepository.findByProject(projectOptional.get());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // Create a new task in a project
    @PostMapping("/projects/{project_id}/tasks")
    public ResponseEntity<Task> createTaskInProject(@PathVariable("project_id") Long projectId,
                                                    @RequestBody Task task) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (!projectOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        task.setProject(projectOptional.get());
        Task newTask = taskRepository.save(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    // Retrieve details of a specific task
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update task details
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task taskDetails) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Task task = taskOptional.get();
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setPriority(taskDetails.getPriority());
        task.setAssignedTo(taskDetails.getAssignedTo());
        task.setDue_date(taskDetails.getDue_date());

        Task updatedTask = taskRepository.save(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // Delete a task
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") Long id) {
        try {
            taskRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
