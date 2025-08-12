package com.myTodoApplication.TodoApplication.utility.response;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Response {
    private int statusCode;
    private boolean status;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();
    private T data;

}
