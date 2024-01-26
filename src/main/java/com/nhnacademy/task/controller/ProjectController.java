package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.project.ProjectDeleteResponse;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.ProjectResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneDeleteResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneResponse;
import com.nhnacademy.task.dto.project.tag.ProjectTagResponse;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {


    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping({"/{projectId}"})
    public ResponseEntity<ProjectResponse> getProject(@PathVariable(name = "projectId") Long id) {

        ProjectResponse projectResponse = projectService.getProjectById(id);

        return new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectRegisterAndModifyResponse> registerProject(
            @RequestBody ProjectRegisterAndModifyRequest registerRequest) {

        ProjectRegisterAndModifyResponse projectRegisterAndModifyResponse =
                projectService.registerProjectByRequest(registerRequest);

        return new ResponseEntity<>(projectRegisterAndModifyResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectRegisterAndModifyResponse> modifyProject(@PathVariable(name = "projectId") Long id
            , @RequestBody ProjectRegisterAndModifyRequest modifyRequest) {

        ProjectRegisterAndModifyResponse projectRegisterAndModifyResponse =
                projectService.modifyProjectByRequestAndId(modifyRequest, id);

        return new ResponseEntity<>(projectRegisterAndModifyResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<ProjectDeleteResponse> deleteProject(@PathVariable(name = "projectId") Long id) {
        projectService.deleteProjectById(id);
        return new ResponseEntity<>(new ProjectDeleteResponse("프로젝트 삭제 완료"), HttpStatus.OK);
    }







}
