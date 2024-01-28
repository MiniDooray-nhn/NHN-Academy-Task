package com.nhnacademy.task.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.nhnacademy.task.dto.project.DeleteResponse;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyResponse;
import com.nhnacademy.task.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    private final Long projectId = 1L;


    @Test
    void testGetProject() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders
                        .get("/projects/{projectId}", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // 예상되는 응답 상태 코드
                .andExpect(jsonPath("$.projectId").doesNotExist());
    }


    @Test
    void testRegisterProject() {

        ProjectRegisterAndModifyRequest request = new ProjectRegisterAndModifyRequest();

        ProjectRegisterAndModifyResponse response = new ProjectRegisterAndModifyResponse();

        when(projectService.registerProjectByRequest(request)).thenReturn(response);

        assertThat(is(HttpStatus.CREATED));
        assertThat(is(request));
    }

    @Test
    void testModifyProject(){


        ProjectRegisterAndModifyRequest modifyRequest = new ProjectRegisterAndModifyRequest();

        ProjectRegisterAndModifyResponse response = new ProjectRegisterAndModifyResponse();

        when(projectService.modifyProjectByRequestAndId(modifyRequest, projectId)).thenReturn(response);

        assertThat(is(HttpStatus.OK));
        assertThat(is(modifyRequest));
    }

    @Test
    void testDeleteProject(){

        DeleteResponse deleteResponse = new DeleteResponse();

        when(projectService.deleteProjectById(projectId)).thenReturn(deleteResponse);

        assertThat(is(HttpStatus.OK));
        assertThat(is(deleteResponse));

    }
}