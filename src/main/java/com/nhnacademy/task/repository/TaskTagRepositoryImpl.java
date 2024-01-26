package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.QProjectTag;
import com.nhnacademy.task.domain.QTag;
import com.nhnacademy.task.domain.QTaskTag;
import com.nhnacademy.task.domain.TaskTag;
import com.nhnacademy.task.dto.tasktag.TaskTagNameResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


public class TaskTagRepositoryImpl extends QuerydslRepositorySupport implements TaskTagRepositoryCustom {
    public TaskTagRepositoryImpl(EntityManager entityManager) {
        super(TaskTag.class);
        this.entityManager = entityManager;
    }

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<TaskTagNameResponse> getAllTaskTagsWithName(Long taskId) {
        QProjectTag projectTag = QProjectTag.projectTag;
        QTag tag = QTag.tag;
        QTaskTag taskTag = QTaskTag.taskTag;

        return new JPAQueryFactory(entityManager)
                .select(Projections.constructor(TaskTagNameResponse.class, taskTag.id, tag.name))
                .from(taskTag)
                .innerJoin(taskTag.projectTag, projectTag)
                .innerJoin(projectTag.tag, tag)
                .where(taskTag.task.id.eq(taskId))
                .fetch();
    }
}

