package com.korea.basic1.Answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    public List<Answer> findByAuthorId(Long authorId) {
        return answerRepository.findByAuthorId(authorId);
    }
}
