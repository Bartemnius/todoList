package com.project.todoList.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "todo_items_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String title;
    private String information;
    private String dueTo;
    private String isCompleted;

}
