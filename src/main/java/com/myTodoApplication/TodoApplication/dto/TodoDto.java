package com.myTodoApplication.TodoApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private boolean status;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "User ID is required")
    private Long userId;
}
