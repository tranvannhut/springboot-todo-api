package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Todo;
import com.example.demo.services.TodoService;

@RestController
@RequestMapping(value = "/api")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/list-todos")
	public ResponseEntity<?> getAllTodo() {
		List<Todo> listTodo = todoService.getAllTodo();
//		new ResponseEntity<List<Todo>>(listTodo, HttpStatus.OK); // same statement below
		return ResponseEntity.ok().body(listTodo);
	}

	@GetMapping("/todo/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") long id) {
		Todo todo = todoService.getTodoById(id);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

	@PostMapping("/addTodo")
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
		Todo addTodo = todoService.saveTodo(todo);
		return new ResponseEntity<Todo>(addTodo, HttpStatus.OK);
	}

	@PutMapping("/updateTodo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") long id, @RequestBody Todo todo) {
		Todo existTodo = todoService.getTodoById(id);
		existTodo.setDateEndTask(todo.getDateEndTask());
		existTodo.setDateStartTask(todo.getDateStartTask());
		existTodo.setStatusName(todo.getStatusName());
		existTodo.setTaskName(todo.getTaskName());
		Todo updateTodo = todoService.saveTodo(existTodo);
		return new ResponseEntity<Todo>(updateTodo, HttpStatus.OK);
//		}
	}

	@DeleteMapping("/deleteTodo/{id}")
	public ResponseEntity<Boolean> deleteTodo(@PathVariable("id") long id) {
		Boolean isDeleted = todoService.deleteTodo(id);
		return ResponseEntity.ok().body(isDeleted);
	}

}
