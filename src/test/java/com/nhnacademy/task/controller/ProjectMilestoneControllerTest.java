package com.nhnacademy.task.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneResponse;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProjectMilestoneController.class)
class ProjectMilestoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjectService projectService;

    private final Long projectId = 1L;
    private final Long milestoneId = 2L;

    @Test
    void testRegisterProjectMilestone() throws Exception {

        ProjectRegisterAndModifyRequest request = new ProjectRegisterAndModifyRequest();

        ProjectRegisterAndModifyResponse response = new ProjectRegisterAndModifyResponse();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/projects/{projectId}/milestone", projectId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
    }

    @Test
    void testGetAllProjectMilestone() throws Exception {

        List<ProjectMileStoneResponse> projectMileStoneResponseList =
                projectService.getAllProjectMilestoneByProjectId(projectId);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/projects/{projectId}/milestone", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());


    }

    @Test
    void testGetProjectMilestone() throws Exception {

        ProjectMileStoneResponse projectMileStoneResponse = projectService.getProjectMilestoneById(milestoneId);

        when(projectService.getProjectMilestoneById(milestoneId)).thenReturn(projectMileStoneResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/projects/milestone/{milestoneId}", milestoneId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    void testModifyProjectMilestone() throws Exception {

        ProjectMileStoneRegisterAndModifyRequest modifyRequest = new ProjectMileStoneRegisterAndModifyRequest();

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/projects/{projectId}/milestone/{milestoneId}", projectId, milestoneId).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modifyRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    void testDeleteProjectMilestone() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/projects/milestone/{milestoneId}", milestoneId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}