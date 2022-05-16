package com.example.demo.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TodoRepository;
import com.example.demo.entities.Todo;
import com.example.demo.services.TodoService;


@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	/**
	 * Get all Todo
	 */
	@Override
	public List<Todo> getAllTodo() {
		return todoRepository.findAll();
	}

	/**
	 * Get information of Todo
	 */
	@Transactional
	@Override
	public Todo getTodoById(long id) {
		return todoRepository.findById(id).get();
	}

	/**
	 * Add/Update information Todo
	 */
	@Transactional
	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	/**
	 * Delete information Todo
	 */
	@Override
	public boolean deleteTodo(long id) {
		Todo todo = todoRepository.getById(id);
		if (todo != null) {
			todoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
