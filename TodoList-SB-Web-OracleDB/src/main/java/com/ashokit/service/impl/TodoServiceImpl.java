package com.ashokit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Todo;
import com.ashokit.mdel.TodoModel;
import com.ashokit.repository.TodoRepository;
import com.ashokit.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<TodoModel> todoList() {
		List<Todo> list = todoRepository.findAll();
		
		List<TodoModel> modelList = new ArrayList<TodoModel>();
		
		list.forEach(tempTodo -> {
			TodoModel tempModel = new TodoModel();
			tempModel.setId(tempTodo.getId());
			tempModel.setTodo(tempTodo.getTodo());
			tempModel.setStatus(tempTodo.getStatus());
			tempModel.setPriority(tempTodo.getPriority());
			modelList.add(tempModel);
		});
		return modelList;
	}

	@Override
	public Optional<TodoModel> saveTodo(TodoModel model) {
		
		Todo temp = new Todo();
		temp.setTodo(model.getTodo());
		temp.setStatus(model.getStatus());
		temp.setPriority(model.getPriority());
		
		Todo save = todoRepository.save(temp);
		
		model.setId(save.getId());
		return Optional.of(model);
	}

	@Override
	public Optional<TodoModel> getTodoById(Integer id) {
		
		Optional<Todo> tempTodo = todoRepository.findById(id);
		
		TodoModel tempModel = new TodoModel();
		tempModel.setId((tempTodo.get().getId()));
		tempModel.setTodo(tempTodo.get().getTodo());
		tempModel.setStatus(tempTodo.get().getStatus());
		tempModel.setPriority(tempTodo.get().getPriority());
		
		return Optional.of(tempModel);
	}

	@Override
	public Optional<TodoModel> updateTodoById(Integer id, TodoModel model) {
		Optional<TodoModel> todoById = getTodoById(id);
		
//		if(!model.getTodo().equals(null))
//			todoById.get().setTodo(model.getTodo());
//		
//		if(!model.getStatus().equals(null))
//			todoById.get().setStatus(model.getStatus());
//		
//		if(!model.getPriority().equals(null))
			todoById.get().setPriority(model.getPriority());
		
		Optional<TodoModel> updatedTodo = saveTodo(model);
		return updatedTodo;
	}

}
