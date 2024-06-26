package com.rafiyad.teamcollab.repo;

import com.rafiyad.teamcollab.model.Comment;
import com.rafiyad.teamcollab.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByTask(Task task);
}
