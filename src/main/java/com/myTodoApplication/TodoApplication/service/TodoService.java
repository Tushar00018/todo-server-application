package com.myTodoApplication.TodoApplication.service;

import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.repository.TodoRepo;
import com.myTodoApplication.TodoApplication.utility.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<TodoEntity> getTodos() {
        return todoRepo.findAll();
    }

    public ApiResponse<Void> addTodo(TodoEntity todo) {
        try {
            todoRepo.save(todo);
            return new ApiResponse<>(200, true, "New Todo Added Successfully", null);
        } catch (RuntimeException e) {
            return new ApiResponse<>(500, false, "Failed to add todo: "+ e.getMessage(), null);
        }
    }

}
