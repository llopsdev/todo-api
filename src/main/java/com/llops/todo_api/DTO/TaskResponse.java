package com.llops.todo_api.DTO;

import java.time.LocalDateTime;

import com.llops.todo_api.enums.Priority;
import com.llops.todo_api.enums.Status;

public class TaskResponse {

	private Long id;
	private String title;
	private Status status;
	private Priority priority;
	private String description;
	private LocalDateTime dueDate;
	private LocalDateTime createdAt;
	
	public TaskResponse() {
		
	}

	public TaskResponse(Long id, String title, Status status, Priority priority, String description,
			LocalDateTime dueDate, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.priority = priority;
		this.description = description;
		this.dueDate = dueDate;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Status getStatus() {
		return status;
	}

	public Priority getPriority() {
		return priority;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	
}

