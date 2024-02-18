package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import com.ashokit.mdel.TodoModel;

public interface TodoService {

	public List<TodoModel> todoList();
	public Optional<TodoModel> saveTodo(TodoModel model);
	public Optional<TodoModel> getTodoById(Integer id);
	public Optional<TodoModel> updateTodoById(Integer id, TodoModel model);
	
}
