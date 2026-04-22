package com.llops.todo_api.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import com.llops.todo_api.enums.Priority;
import com.llops.todo_api.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;


@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	private LocalDateTime dueDate;
	private LocalDateTime createdAt;
	
	public Task() {
		
	}

	public Task(String title, String description, Status status, Priority priority, LocalDateTime dueDate)
	{
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.dueDate = dueDate;
		
	}
	@PrePersist
	public void prePersist() {
		this.createdAt=LocalDateTime.now();
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", priority=" + priority + ", dueDate=" + dueDate + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
}
