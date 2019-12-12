package com.example.api.controller;

import com.example.api.dto.AnswerDto;
import com.example.api.dto.RequestDto;
import com.example.api.service.QueueService;
import com.example.api.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class RequestController {

    private RequestService service;
    private QueueService queueService;

    @Autowired
    public void setQueueService(QueueService queueService) {
        this.queueService = queueService;
    }

    @Autowired
    public void setService(RequestService service) {
        this.service = service;
    }

    @PostMapping("/calculate-gcd")
    public ResponseEntity<Long> calculate(@RequestBody RequestDto requestDto) {
        if(requestDto == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Long id = service.processRequest(requestDto);
        queueService.sendMessage(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/get-result/{id}")
    public @ResponseBody ResponseEntity<AnswerDto> getById(@PathVariable String id) {
        long answerId;
        try {
            answerId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(new AnswerDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        AnswerDto dto = service.getAnswer(answerId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
