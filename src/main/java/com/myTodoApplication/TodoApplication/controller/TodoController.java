package com.myTodoApplication.TodoApplication.controller;

import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.service.TodoService;
import com.myTodoApplication.TodoApplication.utility.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<TodoEntity> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping()
    public ApiResponse<Void> addTodo(@RequestBody TodoEntity todo) {
        return todoService.addTodo(todo);
    }
}
