package com.rafiyad.teamcollab.service;

import com.rafiyad.teamcollab.model.Project;
import com.rafiyad.teamcollab.model.User;
import com.rafiyad.teamcollab.repo.ProjectRepo;
import com.rafiyad.teamcollab.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepository;

    @Autowired
    private UserRepo userRepository;

    public void createProject(String projectName, String projectDescription, Long ownerId) {
        // Find the owner user
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Create a new project
        Project project = new Project();
        project.setName(projectName);
        project.setDescription(projectDescription);
        project.setOwner(owner);

        // Save the project
        projectRepository.save(project);
    }
}
