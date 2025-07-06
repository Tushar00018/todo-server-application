package com.myTodoApplication.TodoApplication.dto;

import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoDto {
    private boolean status;
    private String Description;
    private Long userId;

    public TodoDto() {
    }

    public TodoDto(boolean status, String description, Long userId) {
        this.status = status;
        this.Description = description;
        this.userId = userId;
    }

    public boolean getStatus() {
        return status;
    }

    public String getDescription() {
        return Description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "status=" + status +
                ", Description='" + Description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
