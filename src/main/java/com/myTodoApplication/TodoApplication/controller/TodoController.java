package com.myTodoApplication.TodoApplication.controller;

import com.myTodoApplication.TodoApplication.dto.TodoDto;
import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.service.TodoService;
import com.myTodoApplication.TodoApplication.utility.ApiResponse;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<List<TodoEntity>>> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Void>> addTodo(@RequestBody TodoDto todo) {
        return todoService.addTodo(todo);
    }
}
