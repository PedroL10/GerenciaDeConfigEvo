package edu.example.taskmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.example.taskmanager.dto.CreateTaskRequest;
import edu.example.taskmanager.model.Task;
import edu.example.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService service = new TaskService();

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().body(java.util.Map.of("status", "ok"));
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

    @PostMapping("/tasks/{id}/toggle")
    public ResponseEntity<?> toggle(@PathVariable("id") int id) {
        Task t = service.toggleTask(id);
        if (t == null)
            return ResponseEntity.status(404).body(java.util.Map.of("error", "not found"));
        return ResponseEntity.ok(t);
    }
}
