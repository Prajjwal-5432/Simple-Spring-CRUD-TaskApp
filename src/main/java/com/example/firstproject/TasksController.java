package com.example.firstproject;

import data.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping("/tasks")
public class TasksController {
    ArrayList<Task> tasks;

    public TasksController() {
        this.tasks = new ArrayList<Task>();

        //sample data for tasks
        this.tasks.add(new Task("task1", new Date(), true));
        this.tasks.add(new Task("task2", new Date(), false));
        this.tasks.add(new Task("task3", new Date(), true));
    }

    @GetMapping("")
    public ArrayList<Task> getAllTasks() {
        return this.tasks;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") int id) {
        return this.tasks.get(id);
    }

    @PostMapping("")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        this.tasks.add(new Task(task.getTitle(), task.getStartDate(), task.getCompleted()));
        return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") int id) {
        this.tasks.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable("id") int id, @RequestBody Task updatedTask) {
        Task existingTask = this.tasks.get(id);

        if (existingTask == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }

        if (updatedTask.getTitle() != null) {
            existingTask.setTitle(updatedTask.getTitle());
        }

        if (updatedTask.getStartDate() != null) {
            existingTask.setStartDate(updatedTask.getStartDate());
        }

        if (updatedTask.getCompleted() != null) {
            existingTask.setCompleted(updatedTask.getCompleted());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Task updated successfully");
    }
}
