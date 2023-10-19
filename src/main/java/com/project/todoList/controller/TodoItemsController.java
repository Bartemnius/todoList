package com.project.todoList.controller;

import com.project.todoList.entity.TodoItem;
import com.project.todoList.repository.TodoItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TodoItemsController {

    @Autowired
    private TodoItemsRepository repository;

    @GetMapping("/")
    public ModelAndView getTodoItemsList() {
        List<TodoItem> todoItems = repository.findAll();
        ModelAndView mav = new ModelAndView("todo-items-list");
        mav.addObject("todoItems", todoItems);
        return mav;
    }

}
