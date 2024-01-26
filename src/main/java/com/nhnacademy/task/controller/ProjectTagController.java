package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.project.tag.ProjectTagDeleteResponse;
import com.nhnacademy.task.dto.project.tag.ProjectTagRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.tag.ProjectTagResponse;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectTagController {

    private final ProjectService projectService;

    public ProjectTagController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/tag/{projectTagId}")
    public ResponseEntity<ProjectTagResponse> getProjectTag(@PathVariable(name = "projectTagId") Long projectTagId) {
        ProjectTagResponse projectTagResponse = projectService.getProjectTagById(projectTagId);

        return new ResponseEntity<>(projectTagResponse, HttpStatus.OK);
    }

    @GetMapping("/{projectId}/tag")
    public ResponseEntity<List<ProjectTagResponse>> getAllProjectTag(
            @PathVariable(name = "projectId") Long projectTagId) {

        List<ProjectTagResponse> projectTagResponseList = projectService.getAllProjectTagById(projectTagId);
        return new ResponseEntity<>(projectTagResponseList, HttpStatus.OK);
    }

    @PostMapping("/{projectId}/tag/{tagId}")
    public ResponseEntity<ProjectTagRegisterAndModifyResponse> registerProjectTag(
            @PathVariable(name = "projectId") Long projectId,
            @PathVariable(name = "tagId") Integer tagId) {

        ProjectTagRegisterAndModifyResponse projectTagRegisterAndModifyResponse =
                projectService.registerProjectTag(projectId, tagId);
        return new ResponseEntity<>(projectTagRegisterAndModifyResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{projectTagId}/tag/{tagId}")
    public ResponseEntity<ProjectTagRegisterAndModifyResponse> modifyProjectTag(
            @PathVariable(name = "tagId") Integer tagId,
            @PathVariable(name = "projectTagId") Long projectTagId) {

        ProjectTagRegisterAndModifyResponse projectTagRegisterAndModifyResponse =
                projectService.modifyProjectTag(tagId, projectTagId);
        return new ResponseEntity<>(projectTagRegisterAndModifyResponse, HttpStatus.OK);
    }

    @DeleteMapping("/tag/{projectTagId}")
    public ResponseEntity<ProjectTagDeleteResponse> deleteProjectTag(
            @PathVariable(name = "projectTagId") Long projectTagId) {

        ProjectTagDeleteResponse projectTagDeleteResponse = projectService.deleteProjectTag(projectTagId);

        return new ResponseEntity<>(projectTagDeleteResponse, HttpStatus.OK);
    }

}
