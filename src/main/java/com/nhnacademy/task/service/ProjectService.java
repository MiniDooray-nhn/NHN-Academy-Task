package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.domain.ProjectStatus;
import com.nhnacademy.task.dto.ProjectRegisterAndModifyRequest;
import com.nhnacademy.task.dto.ProjectRegisterResponse;
import com.nhnacademy.task.repository.ProjectMemberRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.ProjectStatusRepository;
import com.nhnacademy.task.repository.ProjectTagRepository;
import java.util.Optional;
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


    public ProjectRegisterResponse registerProjectByRequest(ProjectRegisterAndModifyRequest registerRequest) {

        /**
         * todo 나중에 예외처리
         */
        Project project = new Project();


        Optional<ProjectStatus> projectStatus = projectStatusRepository.findById(registerRequest.getProjectStatusId());


        project.setProject(registerRequest, projectStatus.get());
        project = projectRepository.save(project);

        ProjectRegisterResponse projectRegisterResponse = projectRepository.queryById(project.getId());

        return projectRegisterResponse;

    }




}
