package com.project.todoList.controller;

import com.project.todoList.entity.TodoItem;
import com.project.todoList.repository.TodoItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TodoItemsController {

    @Autowired
    private TodoItemsRepository repository;

    @GetMapping({"/", "/todoItemsList"})
    public ModelAndView getTodoItemsList() {
        List<TodoItem> todoItems = repository.findAll();
        ModelAndView mav = new ModelAndView("todo-items-list");
        mav.addObject("todoItems", todoItems);
        return mav;
    }

    @GetMapping("deleteItem")
    public String deleteItem(@RequestParam Long todoItemId) {
        repository.deleteById(todoItemId);
        return "redirect:/todoItemsList";
    }

    @GetMapping("/addItem")
    public ModelAndView getAddItem() {
        ModelAndView mav = new ModelAndView("add-item");
        TodoItem newItem = new TodoItem();
        mav.addObject("newItem", newItem);
        return mav;
    }

    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute TodoItem newItem) {
        newItem.setIsCompleted("Not done");
        repository.save(newItem);
        return "redirect:/todoItemsList";
    }

}
