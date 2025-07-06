package com.myTodoApplication.TodoApplication.service;

import com.myTodoApplication.TodoApplication.dto.TodoDto;
import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.repository.TodoRepo;
import com.myTodoApplication.TodoApplication.repository.UserRepo;
import com.myTodoApplication.TodoApplication.utility.ApiResponse;
import com.myTodoApplication.TodoApplication.utility.CommonUtilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoService {
    TodoRepo todoRepo;
    UserRepo userRepo;
    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public TodoEntity convertDtoToEntity(TodoDto todoDto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setDescription(todoDto.getDescription());
        todoEntity.setStatus(todoDto.getStatus());

        UserEntity user = userRepo.findById(todoDto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        todoEntity.setUser(user);
        return todoEntity;
    }

    public ResponseEntity<ApiResponse<List<TodoEntity>>> getTodos() {
        List<TodoEntity> response = todoRepo.findAll();
        String message = CommonUtilities.DATA_FETCHED;
        if(response.isEmpty()) {
            message = CommonUtilities.NO_DATA;
        }
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), true, message, response));
    }

    public ResponseEntity<ApiResponse<Void>> addTodo(TodoDto todo) {
        try {
            todoRepo.save(convertDtoToEntity(todo));
            return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), true, CommonUtilities.created("Todo"), null));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, CommonUtilities.failure("Todo", e.getMessage()), null));
        }
    }
}
