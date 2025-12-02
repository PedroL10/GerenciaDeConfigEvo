package edu.example.taskmanager.controller;

import edu.example.taskmanager.service.TaskService;
import edu.example.taskmanager.model.Task;
import edu.example.taskmanager.dto.CreateTaskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService service = new TaskService();

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().body(java.util.Map.of("status","ok"));
    }

    @GetMapping("/tasks")
    public List<Task> listTasks() {
        return service.listTasks();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskRequest req) {
        Task t = service.createTask(req.getTitle(), req.getDone() != null ? req.getDone() : false);
        return ResponseEntity.status(201).body(t);
    }

    @PostMapping("/tasks/<built-in function id>/toggle")
    public ResponseEntity<?> toggle(@PathVariable int id) {
        Task t = service.toggleTask(id);
        if (t == null) return ResponseEntity.status(404).body(java.util.Map.of("error","not found"));
        return ResponseEntity.ok(t);
    }
}
