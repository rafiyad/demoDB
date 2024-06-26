package com.rafiyad.teamcollab.service;

import com.rafiyad.teamcollab.model.Comment;
import com.rafiyad.teamcollab.model.Task;
import com.rafiyad.teamcollab.model.User;
import com.rafiyad.teamcollab.repo.CommentRepo;
import com.rafiyad.teamcollab.repo.TaskRepo;
import com.rafiyad.teamcollab.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private TaskRepo taskRepository;

    public void addComment(String content, Long userId, Long taskId) {
        // Find the user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Find the task
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        // Create a new Comment instance
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(user);
        comment.setTask(task);

        // Save the comment
        commentRepository.save(comment);
    }
}
