package com.rafiyad.teamcollab.service;

import com.rafiyad.teamcollab.model.Project;
import com.rafiyad.teamcollab.model.ProjectMember;
import com.rafiyad.teamcollab.model.User;
import com.rafiyad.teamcollab.repo.ProjectMemberRepo;
import com.rafiyad.teamcollab.repo.ProjectRepo;
import com.rafiyad.teamcollab.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberService {

    @Autowired
    private ProjectMemberRepo projectMemberRepository;

    @Autowired
    private ProjectRepo projectRepository;

    @Autowired
    private UserRepo userRepository;

    public void addProjectMember(Long projectId, Long userId, String role) {
        // Find the project
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        // Find the user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Create a new ProjectMember instance
        ProjectMember projectMember = new ProjectMember();
        projectMember.setProject(project);
        projectMember.setUser(user);
        projectMember.setRole(role);

        // Save the project member
        projectMemberRepository.save(projectMember);
    }
}
