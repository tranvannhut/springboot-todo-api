package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Todo;

public interface TodoService {

	// Get all Todo
	public List<Todo> getAllTodo();

	// Get information of Todo
	public Todo getTodoById(long id);

	// Create/Update for Todo
	public Todo saveTodo(Todo todo);

	// Delete Todo
	public boolean deleteTodo(long id);
}
