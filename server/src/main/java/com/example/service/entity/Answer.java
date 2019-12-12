package com.example.service.entity;

import com.example.service.enums.Status;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    private long id;
    @Column(name = "first")
    private long first;
    @Column(name = "second")
    private long second;
    @Column(name = "status")
    private Status status;
    @Column(name = "result")
    private Long result;
    @Column(name = "error")
    private String error;

    public Answer() {
    }

    public Answer(long first, long second) {
        this.first = first;
        this.second = second;
        this.status = Status.NOT_COMPLETE;
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

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", first=" + first +
                ", second=" + second +
                ", status='" + status + '\'' +
                ", result=" + result +
                ", error='" + error + '\'' +
                '}';
    }
}
