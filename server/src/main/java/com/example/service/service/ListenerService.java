package com.example.service.service;

import com.example.service.entity.Answer;
import com.example.service.enums.Status;
import com.example.service.repos.AnswerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListenerService {
    Logger logger = LogManager.getLogger(ListenerService.class);

    private DivideService divideService;
    private AnswerRepository repository;

    @Autowired
    public void setDivideService(DivideService divideService) {
        this.divideService = divideService;
    }

    @Autowired
    public void setRepository(AnswerRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "ansqueue")
    public void listen(String in) {
        System.out.println("in");
        System.out.println(in);
        long id;
        try {
            id = Long.parseLong(in);
            System.out.println("parse");
            Optional<Answer> ans = repository.findById(id);
            Answer answer = ans.orElse(null);
            if (answer != null) {
                long result = divideService.findCommonDivider(answer.getFirst(), answer.getSecond());
                answer.setResult(result);
                answer.setStatus(Status.COMPLETE);
                repository.save(answer);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}
