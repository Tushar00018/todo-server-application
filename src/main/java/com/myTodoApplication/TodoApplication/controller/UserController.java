package com.myTodoApplication.TodoApplication.controller;

import com.myTodoApplication.TodoApplication.dto.UserDto;
import com.myTodoApplication.TodoApplication.service.UserService;
import com.myTodoApplication.TodoApplication.utility.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<UserDto>>> getUsers() {
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), true, "Data fetched Successfully", userService.getUsers()));
    }
}
