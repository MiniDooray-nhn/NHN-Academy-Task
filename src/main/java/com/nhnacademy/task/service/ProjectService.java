package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.domain.ProjectMilestone;
import com.nhnacademy.task.domain.ProjectStatus;
import com.nhnacademy.task.domain.ProjectTag;
import com.nhnacademy.task.domain.Tag;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.ProjectResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneResponse;
import com.nhnacademy.task.dto.project.tag.ProjectTagDeleteResponse;
import com.nhnacademy.task.dto.project.tag.ProjectTagRegisterAndModifyResponse;
import com.nhnacademy.task.dto.project.tag.ProjectTagResponse;
import com.nhnacademy.task.repository.ProjectMemberRepository;
import com.nhnacademy.task.repository.ProjectMileStoneRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.ProjectStatusRepository;
import com.nhnacademy.task.repository.ProjectTagRepository;
import com.nhnacademy.task.repository.TagRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectTagRepository projectTagRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectStatusRepository projectStatusRepository;

    private final ProjectMileStoneRepository projectMileStoneRepository;

    private final TagRepository tagRepository;


    public ProjectService(ProjectRepository projectRepository, ProjectTagRepository projectTagRepository,
                          ProjectMemberRepository projectMemberRepository,
                          ProjectStatusRepository projectStatusRepository,
                          ProjectMileStoneRepository projectMileStoneRepository, TagRepository tagRepository) {
        this.projectRepository = projectRepository;
        this.projectTagRepository = projectTagRepository;
        this.projectMemberRepository = projectMemberRepository;
        this.projectStatusRepository = projectStatusRepository;
        this.projectMileStoneRepository = projectMileStoneRepository;
        this.tagRepository = tagRepository;
    }

    public ProjectResponse getProjectById(Long id) {
        /**
         * 프로젝트 없으면 예외처리
         */

        return projectRepository.queryById(id);
    }

    @Transactional
    public ProjectRegisterAndModifyResponse registerProjectByRequest(ProjectRegisterAndModifyRequest registerRequest) {

        Project project = new Project();


        // 프로젝트 상태 없으면 예외처리
        Optional<ProjectStatus> projectStatus = projectStatusRepository.findById(registerRequest.getProjectStatusId());

        if (projectStatus.isEmpty()) {
            throw new IllegalArgumentException();
        }

        project.setProjectByRegisterRequest(registerRequest, projectStatus.get());
        project = projectRepository.save(project);


        return project.converToDto();
    }

    @Transactional
    public ProjectRegisterAndModifyResponse modifyProjectByRequestAndId(ProjectRegisterAndModifyRequest modifyRequest,
                                                                        Long id) {

        // 찾았는데 없으면 예외처리
        Project project = projectRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        // 상태없으면 예외처리
        ProjectStatus projectStatus = projectStatusRepository.findById(modifyRequest.getProjectStatusId()).orElseThrow(
                IllegalArgumentException::new);

        project.setProjectByModifyRequest(modifyRequest, projectStatus);
        project = projectRepository.save(project);


        return project.converToDto();
    }

    @Transactional
    public void deleteProjectById(Long id) {

        // 프로젝트 없으면
        projectRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        projectRepository.deleteById(id);
    }


    @Transactional
    public ProjectMileStoneRegisterAndModifyResponse registerProjectMileStoneByRequestAndId(Long projectId,
                                                                                            ProjectMileStoneRegisterAndModifyRequest registerRequest) {

        ProjectMilestone projectMilestone = new ProjectMilestone();

        // 프로젝트 업으면 터치기
        Project project = projectRepository.findById(projectId).orElseThrow(IllegalArgumentException::new);

        projectMilestone.setProjectMileStoneByRegisterRequest(project, registerRequest);

        projectMilestone = projectMileStoneRepository.save(projectMilestone);


        return projectMilestone.convertToDto();
    }

    public List<ProjectMileStoneResponse> getAllProjectMilestoneByProjectId(Long projectId) {

        List<ProjectMileStoneResponse> projectMileStoneResponseList =
                projectMileStoneRepository.findAllByProjectId(projectId);


        return projectMileStoneResponseList;
    }

    public ProjectMileStoneResponse getProjectMilestoneById(Long milestoneId) {

        return projectMileStoneRepository.queryById(milestoneId).get();

    }

    @Transactional
    public void deleteProjectMilestoneById(Long milestoneId) {

        ProjectMilestone projectMilestone =
                projectMileStoneRepository.findById(milestoneId).orElseThrow(IllegalArgumentException::new);

        projectMileStoneRepository.deleteById(milestoneId);

    }


    @Transactional
    public ProjectMileStoneRegisterAndModifyResponse modifyProjectMilestoneByRequestAndId(Long milestoneId,
                                                                                          Long projectId,
                                                                                          ProjectMileStoneRegisterAndModifyRequest modifyRequest) {
        // 없으면 예외
        ProjectMilestone projectMilestone =
                projectMileStoneRepository.findById(milestoneId)
                        .orElseThrow(IllegalArgumentException::new);


        projectMilestone.setProjectMileStoneByModifyRequest(modifyRequest);

        projectMileStoneRepository.save(projectMilestone);

        return projectMilestone.convertToDto();
    }

    public List<ProjectTagResponse> getAllProjectTagById(Long projectTagId) {

        List<ProjectTagResponse> projectTagList = projectTagRepository.findAllByProjectId(projectTagId);

        return projectTagList;
    }

    public ProjectTagResponse getProjectTagById(Long projectTagId) {

        ProjectTagResponse projectTagResponse = projectTagRepository.queryById(projectTagId);
        return projectTagResponse;
    }

    public ProjectTagRegisterAndModifyResponse registerProjectTag(Long projectId, Integer tagId) {

        System.out.println(projectId + " " + tagId);

        // 테그없으면 터치기
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);

        Project project = projectRepository.findById(projectId).orElseThrow(IllegalArgumentException::new);

        ProjectTag projectTag = new ProjectTag();

        projectTag.setProject(project);
        projectTag.setTag(tag);


        projectTagRepository.save(projectTag);

        ProjectTagRegisterAndModifyResponse tagRegisterAndModifyRequest = new ProjectTagRegisterAndModifyResponse();
        tagRegisterAndModifyRequest.setProjectId(projectId);
        tagRegisterAndModifyRequest.setTagName(tag.getName());
        return tagRegisterAndModifyRequest;
    }

    public ProjectTagRegisterAndModifyResponse modifyProjectTag(Integer tagId, Long projectTagId) {

        // 없으면 터치기
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);

        ProjectTag projectTag =
                projectTagRepository.findById(projectTagId).orElseThrow(IllegalArgumentException::new);

        projectTag.setTag(tag);

        projectTagRepository.save(projectTag);

        ProjectTagRegisterAndModifyResponse tagRegisterAndModifyRequest = new ProjectTagRegisterAndModifyResponse();
        tagRegisterAndModifyRequest.setTagName(tag.getName());
        tagRegisterAndModifyRequest.setProjectId(projectTag.getProject().getId());


        return tagRegisterAndModifyRequest;
    }

    public ProjectTagDeleteResponse deleteProjectTag(Long projectTagId) {

        ProjectTag projectTag =
                projectTagRepository.findById(projectTagId).orElseThrow(IllegalArgumentException::new);

        projectTagRepository.deleteById(projectTagId);
        return new ProjectTagDeleteResponse("프로젝트 테그 삭제");
    }


}
