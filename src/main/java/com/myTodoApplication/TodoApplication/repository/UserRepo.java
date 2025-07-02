package com.myTodoApplication.TodoApplication.repository;

import com.myTodoApplication.TodoApplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
}
