package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.ProjectMember;
import com.nhnacademy.task.dto.project.member.ProjectMemberResponse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long> {


    List<ProjectMemberResponse> queryAllByProjectId(Long projectId);

}
