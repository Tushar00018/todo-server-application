package com.myTodoApplication.TodoApplication.controller;

import com.myTodoApplication.TodoApplication.dto.TodoDto;
import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.service.TodoService;
import com.myTodoApplication.TodoApplication.utility.response.ApiResponse;
import com.myTodoApplication.TodoApplication.utility.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Lazy
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping()
    public ResponseEntity<Response> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping()
    public ResponseEntity<Response> addTodo(@RequestBody @Valid TodoDto todo) {
        return todoService.addTodo(todo);
    }
}
