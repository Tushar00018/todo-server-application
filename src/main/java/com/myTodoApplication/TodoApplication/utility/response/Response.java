package com.myTodoApplication.TodoApplication.utility.response;

public interface Response {
    int getStatusCode();
    boolean isStatus();
    String getMessage();
}
