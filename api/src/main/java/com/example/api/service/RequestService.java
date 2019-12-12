package com.example.api.service;

import com.example.api.dto.AnswerDto;
import com.example.api.dto.RequestDto;
import com.example.api.entity.Answer;
import com.example.api.repos.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class RequestService {

    private AnswerRepository repository;

    @Autowired
    public void setRepository(AnswerRepository repository) {
        this.repository = repository;
    }

    public Long processRequest(RequestDto requestDto) {
        Answer answer = new Answer(requestDto.getFirst(), requestDto.getSecond());
        repository.save(answer);
        System.out.println(answer.getId());
        return answer.getId();
    }

    public AnswerDto getAnswer(long id) {
        AnswerDto answerDto;
        try {
            Answer dbAnswer = repository.getOne(id);
            answerDto = dbAnswer.toDto();

        } catch (EntityNotFoundException e) {
            answerDto = new AnswerDto(e.getMessage());
        }
        return answerDto;
    }
}
