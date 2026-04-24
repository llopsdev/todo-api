package com.llops.todo_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.llops.todo_api.entity.Task;
import com.llops.todo_api.enums.Status;
import com.llops.todo_api.enums.Priority;



public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByStatus(Status status);
	List<Task> findByPriority(Priority priority);
	List<Task> findByStatusAndPriority(Status status, Priority priority);
}
