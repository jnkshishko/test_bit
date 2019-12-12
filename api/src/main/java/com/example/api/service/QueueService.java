package com.example.api.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueService {

    private RabbitTemplate template;

    @Autowired
    public void setTemplate(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(Object message) {
        template.convertAndSend("ansqueue", message);
    }
}
