package com.myTodoApplication.TodoApplication.controller;

import com.myTodoApplication.TodoApplication.dto.TodoDto;
import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.service.TodoService;
import com.myTodoApplication.TodoApplication.utility.response.ApiResponse;
import com.myTodoApplication.TodoApplication.utility.response.Response;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<Response> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping()
    public ResponseEntity<Response> addTodo(@RequestBody TodoDto todo) {
        return todoService.addTodo(todo);
    }
}
