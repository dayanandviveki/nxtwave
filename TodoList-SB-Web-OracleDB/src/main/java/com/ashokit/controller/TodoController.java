package com.ashokit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.mdel.TodoModel;
import com.ashokit.service.TodoService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/todo")
@ResponseBody
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todos")
	public Optional<TodoModel> saveTodo(@RequestBody TodoModel model) {
		Optional<TodoModel> saveTodo = todoService.saveTodo(model);
		return (Optional<TodoModel>) saveTodo;
	}
	
	@GetMapping("/todolist")
	public List<TodoModel> getTodoList() {
		List<TodoModel> todoList = todoService.todoList();
		return todoList;
	}
	
	@GetMapping("/byid/{id}")
	public Optional<TodoModel> getTodoWithId(@PathVariable("id") Integer id) {
		Optional<TodoModel> getById = todoService.getTodoById(id);
		return (Optional<TodoModel>) getById;
	}
	
	@PutMapping("/putbyid/{id}")
	public Optional<TodoModel> updateById(@PathVariable("id") Integer id,@RequestBody TodoModel model) {
		Optional<TodoModel> getById = todoService.updateTodoById(id,model);
		return (Optional<TodoModel>) getById;
	}
	
	
	
		
}
