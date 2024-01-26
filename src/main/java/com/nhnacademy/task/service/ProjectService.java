package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.domain.ProjectStatus;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.ProjectResponse;
import com.nhnacademy.task.repository.ProjectMemberRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.ProjectStatusRepository;
import com.nhnacademy.task.repository.ProjectTagRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectTagRepository projectTagRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectStatusRepository projectStatusRepository;

    public ProjectService(ProjectRepository projectRepository, ProjectTagRepository projectTagRepository,
                          ProjectMemberRepository projectMemberRepository,
                          ProjectStatusRepository projectStatusRepository) {
        this.projectRepository = projectRepository;
        this.projectTagRepository = projectTagRepository;
        this.projectMemberRepository = projectMemberRepository;
        this.projectStatusRepository = projectStatusRepository;
    }


    public ProjectResponse getProjectById(Long id) {

        Project project = projectRepository.findById(id).orElseThrow(IllegalAccessError::new);


        System.out.println(project.getTitle());
        System.out.println(project.getCreatedAt());

        return projectRepository.findByProjectId(id);
    }

    public ProjectResponse registerProjectByRequest(ProjectRegisterAndModifyRequest registerRequest) {

        /**
         * todo 나중에 예외처리
         */
        Project project = new Project();


        ProjectStatus projectStatus = projectStatusRepository.findById(registerRequest.getProjectStatusId())
                .orElseThrow(IllegalArgumentException::new);


        project.setProjectByRegisterRequest(registerRequest, projectStatus);
        project = projectRepository.save(project);

        ProjectResponse projectRegisterAndModifyResponse =
                projectRepository.findByProjectId(project.getProjectId());

        return projectRegisterAndModifyResponse;
    }

    public ProjectResponse modifyProjectByRequestAndId(ProjectRegisterAndModifyRequest modifyRequest,
                                                                        Long id) {

        Project project = projectRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        ProjectStatus projectStatus = projectStatusRepository.findById(modifyRequest.getProjectStatusId()).orElseThrow(
                IllegalArgumentException::new);

        project.setProjectByModifyRequest(modifyRequest, projectStatus);
        project = projectRepository.save(project);

        ProjectResponse projectRegisterAndModifyResponse =
                projectRepository.findByProjectId(project.getProjectId());

        return projectRegisterAndModifyResponse;
    }

    public void deleteProjectById(Long id) {

        if (projectRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException();
        }

        projectRepository.deleteById(id);
    }


}
