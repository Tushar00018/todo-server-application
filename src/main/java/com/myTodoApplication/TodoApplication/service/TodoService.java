package com.myTodoApplication.TodoApplication.service;

import com.myTodoApplication.TodoApplication.dto.TodoDto;
import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.repository.TodoRepo;
import com.myTodoApplication.TodoApplication.repository.UserRepo;
import com.myTodoApplication.TodoApplication.utility.response.ApiResponse;
import com.myTodoApplication.TodoApplication.utility.CommonUtilities;

import com.myTodoApplication.TodoApplication.utility.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    private final TodoRepo todoRepo;
    private final UserRepo userRepo;
    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public ResponseEntity<Response> getTodos() {
        List<TodoEntity> todos = todoRepo.findAll();
        String message = todos.isEmpty() ? CommonUtilities.NO_DATA : CommonUtilities.DATA_FETCHED;

        ApiResponse<List<TodoEntity>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                true,
                message,
                todos
        );
        log.info(message);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Response> addTodo(TodoDto todoDto) {
        TodoEntity todoEntity = convertDtoToEntity(todoDto);
        todoRepo.save(todoEntity);
        String message = CommonUtilities.created("Todo");
        ApiResponse<Void> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                true,
                message,
                null
        );
        log.info(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private TodoEntity convertDtoToEntity(TodoDto todoDto) {
        UserEntity user = userRepo.findById(todoDto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setDescription(todoDto.getDescription());
        todoEntity.setStatus(todoDto.isStatus());
        todoEntity.setUser(user);

        return todoEntity;
    }
}
