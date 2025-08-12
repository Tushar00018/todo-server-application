package com.myTodoApplication.TodoApplication.service;

import com.myTodoApplication.TodoApplication.dto.UserDto;
import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.repository.UserRepo;
import com.myTodoApplication.TodoApplication.utility.response.ApiResponse;
import com.myTodoApplication.TodoApplication.utility.CommonUtilities;
import com.myTodoApplication.TodoApplication.utility.response.ErrorResponse;
import com.myTodoApplication.TodoApplication.utility.response.Response;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Lazy
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

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
}
