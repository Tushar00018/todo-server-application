package com.myTodoApplication.TodoApplication.service;

import com.myTodoApplication.TodoApplication.dto.UserDto;
import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private UserDto convertToUserDto(UserEntity user) {
        return new UserDto(user.getId(), user.getUserName(), user.getTodos()); // Example
    }

    public List<UserDto> getUsers() {
        return userRepo.findAll().stream().map(this::convertToUserDto).collect(Collectors.toList());
    }
}
