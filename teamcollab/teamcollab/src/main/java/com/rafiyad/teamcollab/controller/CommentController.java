package com.rafiyad.teamcollab.controller;

import com.rafiyad.teamcollab.model.Comment;
import com.rafiyad.teamcollab.model.Task;
import com.rafiyad.teamcollab.repo.CommentRepo;
import com.rafiyad.teamcollab.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentRepo commentRepository;

    @Autowired
    private TaskRepo taskRepository;

    // Retrieve a list of all comments on a task
    @GetMapping("/tasks/{task_id}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsOnTask(@PathVariable("task_id") Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (!taskOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Comment> comments = commentRepository.findByTask(taskOptional.get());
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Create a new comment on a task
    @PostMapping("/tasks/{task_id}/comments")
    public ResponseEntity<Comment> createCommentOnTask(@PathVariable("task_id") Long taskId,
                                                       @RequestBody Comment comment) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (!taskOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        comment.setTask(taskOptional.get());
        Comment newComment = commentRepository.save(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    // Retrieve details of a specific comment
    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        return commentOptional.map(comment -> new ResponseEntity<>(comment, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update comment details
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable("id") Long id, @RequestBody Comment commentDetails) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Comment comment = commentOptional.get();
        comment.setContent(commentDetails.getContent());

        Comment updatedComment = commentRepository.save(comment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    // Delete a comment
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") Long id) {
        try {
            commentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
