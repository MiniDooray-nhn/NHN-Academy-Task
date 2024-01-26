package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long> {
}
