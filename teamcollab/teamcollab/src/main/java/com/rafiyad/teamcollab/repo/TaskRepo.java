package com.rafiyad.teamcollab.repo;

import com.rafiyad.teamcollab.model.Project;
import com.rafiyad.teamcollab.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    List<Task> findByProject(Project project);
}