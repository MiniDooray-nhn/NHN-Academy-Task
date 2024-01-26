package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneDeleteResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneResponse;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ProjectMilestoneController {

    private final ProjectService projectService;

    public ProjectMilestoneController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping("/{projectId}/milestone")
    public ResponseEntity<ProjectMileStoneRegisterAndModifyResponse> registerProjectMilestone(
            @PathVariable(name = "projectId") Long projectId,
            @RequestBody ProjectMileStoneRegisterAndModifyRequest registerRequest) {

        ProjectMileStoneRegisterAndModifyResponse projectMileStoneResponse =
                projectService.registerProjectMileStoneByRequestAndId(projectId, registerRequest);

        return new ResponseEntity<>(projectMileStoneResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}/milestone")
    public ResponseEntity<List<ProjectMileStoneResponse>> getAllProjectMilestone(
            @PathVariable(name = "projectId") Long id) {

        List<ProjectMileStoneResponse> projectMileStoneResponseList =
                projectService.getAllProjectMilestoneByProjectId(id);
        return new ResponseEntity<>(projectMileStoneResponseList, HttpStatus.CREATED);
    }

    @GetMapping("/milestone/{milestoneId}")
    public ResponseEntity<ProjectMileStoneResponse> getProjectMilestone(
            @PathVariable(name = "milestoneId") Long milestoneId) {
        ProjectMileStoneResponse projectMileStoneResponse = projectService.getProjectMilestoneById(milestoneId);
        return new ResponseEntity<>(projectMileStoneResponse, HttpStatus.OK);
    }

    @PutMapping("{projectId}/milestone/{milestoneId}")
    public ResponseEntity<ProjectMileStoneRegisterAndModifyResponse> modifyProjectMilestone(
            @PathVariable(name = "projectId") Long projectId, @PathVariable(name = "milestoneId") Long milestoneId,
            @RequestBody ProjectMileStoneRegisterAndModifyRequest modifyRequest) {

        ProjectMileStoneRegisterAndModifyResponse modifyResponse =
                projectService.modifyProjectMilestoneByRequestAndId(milestoneId, projectId, modifyRequest);

        return new ResponseEntity<>(modifyResponse, HttpStatus.OK);

    }

    @DeleteMapping("/milestone/{milestoneId}")
    public ResponseEntity<ProjectMileStoneDeleteResponse> deleteProjectMilestone(
            @PathVariable(name = "milestoneId") Long milestoneId) {

        projectService.deleteProjectMilestoneById(milestoneId);
        return new ResponseEntity<>(new ProjectMileStoneDeleteResponse("프로젝트에서 마일스톤 삭제 완료"), HttpStatus.OK);
    }


}
