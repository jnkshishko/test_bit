package com.example.service;

import com.example.service.repos.AnswerRepository;
import com.example.service.service.DivideService;

import com.example.service.service.ListenerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
class ServiceApplicationTests {

    @Autowired
    private DivideService divideService;

    @Mock
    private AnswerRepository repository;

    @Autowired
    private ListenerService listenerService;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindDivide() {
        Assert.assertEquals(5, divideService.findCommonDivider(10, 5));
    }
}
