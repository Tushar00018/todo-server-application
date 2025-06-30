package com.myTodoApplication.TodoApplication.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class ApiResponse<T> {
    private int statusCode;
    private boolean status;
    private String message;
    private LocalDateTime time;
    private T data;
}
