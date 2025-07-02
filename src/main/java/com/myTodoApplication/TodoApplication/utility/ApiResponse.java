package com.myTodoApplication.TodoApplication.utility;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@ToString
@Component
public class ApiResponse<T> {
    private int statusCode;
    private boolean status;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
    private T data;

    public ApiResponse(int statusCode, boolean status, String message, T data) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
