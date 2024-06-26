package com.rafiyad.teamcollab.repo;

import com.rafiyad.teamcollab.model.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepo extends JpaRepository<ProjectMember, Long> {

}