package com.myTodoApplication.TodoApplication.dto;

import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class UserDto {
    private Long id;
    private String userName;
    private List<TodoEntity> todos;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }

    public UserDto(Long id, String userName, List<TodoEntity> todos) {
        this.id = id;
        this.userName = userName;
        this.todos = todos;
    }
}
