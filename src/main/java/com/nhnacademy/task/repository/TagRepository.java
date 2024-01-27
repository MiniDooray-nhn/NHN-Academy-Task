package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.Tag;
import com.nhnacademy.task.dto.project.tag.TagResponse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer> {


    List<TagResponse> queryAllBy();

}
