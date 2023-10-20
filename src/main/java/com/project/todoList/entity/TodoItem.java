package com.project.todoList.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
    private String date;

    private String isCompleted;

}
