package com.example.api.dto;

import com.example.api.enums.Status;

public class AnswerDto {
    private long id;
    private long first;
    private long second;
    private Status status;
    private Long result;
    private String error;

    public AnswerDto(String error) {
        this.error = error;
        this.status = Status.ERROR;
    }

    public AnswerDto(long id, long first, long second,
                     Status status, Long result, String error) {
        this.id = id;
        this.first = first;
        this.second = second;
        this.status = status;
        this.result = result;
        this.error = error;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
