package com.myTodoApplication.TodoApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "Todo")
@AllArgsConstructor
@Getter
@Setter
@Data
@NoArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long Id;


    @Column(name = "Status", nullable = false)
    private boolean status = false;

    @Column(name = "Description", nullable = false)
    @NotBlank(message = "Description cannot be blank")
    private String Description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserEntity user;
}
