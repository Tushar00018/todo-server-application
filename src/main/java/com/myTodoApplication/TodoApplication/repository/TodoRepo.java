package com.myTodoApplication.TodoApplication.repository;

import com.myTodoApplication.TodoApplication.entity.TodoEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoRepo extends JpaRepository<TodoEntity, Long> {
}
