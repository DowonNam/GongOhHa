package com.korea.basic1.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    public List<Question> findByAuthorId(Long authorId) {
        return questionRepository.findByAuthorId(authorId);
    }
}
