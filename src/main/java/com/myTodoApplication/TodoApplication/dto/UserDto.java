package com.myTodoApplication.TodoApplication.dto;

import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private List<TodoEntity> todos;

}
