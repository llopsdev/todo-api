package com.llops.todo_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llops.todo_api.entity.Task;
import com.llops.todo_api.service.TaskService;



@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService=taskService;
	}
	@PostMapping
	public ResponseEntity<Task>createTask(@RequestBody Task task){
		return ResponseEntity.status(201).body(taskService.create(task));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Task>updateTask(@PathVariable Long id, @RequestBody Task task){
		return ResponseEntity.status(200).body(taskService.update(id, task));
	}
	@GetMapping
	public ResponseEntity<List<Task>>findAll(){
		return ResponseEntity.status(200).body(taskService.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Task>findById(@PathVariable Long id){
		return ResponseEntity.status(200).body(taskService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		taskService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
