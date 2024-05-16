package com.korea.basic1.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer>, JpaSpecificationExecutor<Question> {
    List<Question> findByAuthorId(Long authorId);
}
