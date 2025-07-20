package com.myTodoApplication.TodoApplication.service;

import com.myTodoApplication.TodoApplication.dto.UserDto;
import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.repository.UserRepo;
import com.myTodoApplication.TodoApplication.utility.response.ApiResponse;
import com.myTodoApplication.TodoApplication.utility.CommonUtilities;
import com.myTodoApplication.TodoApplication.utility.response.ErrorResponse;
import com.myTodoApplication.TodoApplication.utility.response.Response;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private UserDto convertToUserDto(UserEntity user) {
        return new UserDto(user.getId(), user.getUserName(), user.getTodos()); // Example
    }

    public ResponseEntity<Response> getUsers() {
        List<UserDto> response = userRepo.findAll().stream().map(this::convertToUserDto).collect(Collectors.toList());
        log.info(CommonUtilities.DATA_FETCHED);
        return ResponseEntity.ok().body(
                new ApiResponse<>(
                    HttpStatus.OK.value(),
                    true,
                    CommonUtilities.DATA_FETCHED,
                    response
                )
        );
    }

    public ResponseEntity<? extends Response> createUser(UserEntity user) {
        userRepo.save(user);
        String message = CommonUtilities.created("User");
        log.info(message);
        ApiResponse<Void> body = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                true,
                message,
                null
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}
