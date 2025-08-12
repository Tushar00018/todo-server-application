package com.myTodoApplication.TodoApplication.controller;

import com.myTodoApplication.TodoApplication.dto.UserDto;
import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.service.UserService;
import com.myTodoApplication.TodoApplication.utility.response.ApiResponse;
import com.myTodoApplication.TodoApplication.utility.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Lazy
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<Response> getUsers() {
        return userService.getUsers();
    }

}
