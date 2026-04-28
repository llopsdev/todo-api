package com.llops.todo_api.DTO;

import java.time.LocalDateTime;

import com.llops.todo_api.enums.Priority;
import com.llops.todo_api.enums.Status;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskRequest {
	
	@NotBlank
	private String title;
	private String description;
	private Status status;
	private Priority priority;
	@NotNull
	@Future
	private LocalDateTime dueDate;
	
	public TaskRequest() {
		
	}

	public TaskRequest(@NotBlank String title, String description, Status status, Priority priority,
			@NotNull @Future LocalDateTime dueDate) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}


	
}
