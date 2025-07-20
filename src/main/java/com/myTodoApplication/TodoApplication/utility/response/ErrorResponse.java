package com.myTodoApplication.TodoApplication.utility.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Response {
    private int statusCode;
    private boolean status;
    private String message;
}
