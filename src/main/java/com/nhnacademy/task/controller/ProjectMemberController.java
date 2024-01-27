package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.project.member.ProjectMemberResponse;
import com.nhnacademy.task.dto.project.member.ProjectMemberRegisterResponse;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectMemberController {

    private final ProjectService projectService;

    public ProjectMemberController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/{projectId}/member")
    public ResponseEntity<List<ProjectMemberResponse>> getAllProjectMemberById(
            @PathVariable(name = "projectId") Long projectId) {

        List<ProjectMemberResponse> projectMemberResponseList =
                projectService.getAllProjectMember(projectId);

        return new ResponseEntity<>(projectMemberResponseList, HttpStatus.OK);
    }

    @PostMapping("/{projectId}/member/{userId}")
    public ResponseEntity<ProjectMemberRegisterResponse> registerProjectMember(
            @PathVariable(name = "projectId") Long projectId,
            @PathVariable(name = "userId") String userId) {

        ProjectMemberRegisterResponse
                projectMemberRegisterResponse = projectService.registerProjectMember(projectId, userId);

        return new ResponseEntity<>(projectMemberRegisterResponse, HttpStatus.CREATED);
    }

}
