package com.llops.todo_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llops.todo_api.DTO.TaskRequest;
import com.llops.todo_api.DTO.TaskResponse;
import com.llops.todo_api.entity.Task;
import com.llops.todo_api.enums.Priority;
import com.llops.todo_api.enums.Status;
import com.llops.todo_api.service.TaskService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService=taskService;
	}
	@PostMapping
	public ResponseEntity<TaskResponse>createTask(@RequestBody @Valid TaskRequest taskRequest){
		Task task= toEntity(taskRequest);
		Task taskCreated=taskService.create(task);
		TaskResponse taskResponse= toResponse(taskCreated);
		
		return ResponseEntity.status(201).body(taskResponse);
	}
	@PutMapping("/{id}")
	public ResponseEntity<TaskResponse>updateTask(@PathVariable Long id, @RequestBody @Valid TaskRequest taskRequest){
		Task taskUpdated=taskService.update(id, toEntity(taskRequest));
		TaskResponse taskResponse=toResponse(taskUpdated);		
		
			return ResponseEntity.status(200).body(taskResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TaskResponse>findById(@PathVariable Long id){
		TaskResponse taskResponse= toResponse(taskService.findById(id));
		
		return ResponseEntity.status(200).body(taskResponse);
	}
	@GetMapping
	public ResponseEntity<List<TaskResponse>>findWithFilter(@RequestParam (required = false) Status status,@RequestParam (required = false) Priority priority){
		List<TaskResponse>taskList=taskService.findWithFilter(status, priority).stream().map(task ->toResponse(task)).collect(Collectors.toList());
		
		
		return ResponseEntity.status(200).body(taskList);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		taskService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//CONVERTE REQUEST PARA ENTIDADE
	private Task toEntity(TaskRequest taskRequest) {
		Task task = new Task();
		task.setTitle(taskRequest.getTitle());
		task.setDescription(taskRequest.getDescription());
		task.setDueDate(taskRequest.getDueDate());
		task.setStatus(taskRequest.getStatus());
		task.setPriority(taskRequest.getPriority());
		return task;
}
	//CONVERTE A ENTIDADE PARA RESPONSE
	private TaskResponse toResponse(Task task) {
		TaskResponse taskResponse = new TaskResponse(task.getId(),task.getTitle(),task.getStatus(),task.getPriority(),task.getDescription(),task.getDueDate(),task.getCreatedAt());
		return taskResponse;
		
	}
}
