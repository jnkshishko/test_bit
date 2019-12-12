package com.example.service.service;

import org.springframework.stereotype.Service;

@Service
public class DivideService {

    public long findCommonDivider(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
