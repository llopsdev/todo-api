package com.llops.todo_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.llops.todo_api.entity.Task;
import com.llops.todo_api.enums.Priority;
import com.llops.todo_api.enums.Status;
import com.llops.todo_api.exception.ResourceNotFoundException;
import com.llops.todo_api.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Task create(Task task) {
		if (task.getStatus() == null) {
			task.setStatus(Status.NOT_STARTED);
		}

		if (task.getPriority() == null) {
			task.setPriority(Priority.MEDIUM);
		}

		if (task.getDueDate() == null) {
			throw new IllegalArgumentException("Field dueDate cannot be Null");
		}

		if (task.getDueDate().isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("dueDate cannot be before current date");
		}

		return taskRepository.save(task);
	}

	public Task findById(Long id) {

		return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found."));

	}

	public List<Task> findAll() {

		return taskRepository.findAll();
	}

	public void delete(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
		taskRepository.delete(task);
	}

	public Task update(Long id, Task taskUpdated) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));

		if (taskUpdated.getDueDate() == null) {
			throw new IllegalArgumentException("Field dueDate cannot be Null");
		}

		if (taskUpdated.getDueDate().isBefore(LocalDateTime.now())) {
			throw new IllegalArgumentException("dueDate cannot be before current date");
		}

		if (taskUpdated.getStatus() == null) {
			taskUpdated.setStatus(Status.NOT_STARTED);
		}

		if (taskUpdated.getPriority() == null) {
			taskUpdated.setPriority(Priority.MEDIUM);
		}

		task.setTitle(taskUpdated.getTitle());
		task.setDescription(taskUpdated.getDescription());
		task.setDueDate(taskUpdated.getDueDate());
		task.setStatus(taskUpdated.getStatus());
		task.setPriority(taskUpdated.getPriority());

		return taskRepository.save(task);
	}

}
