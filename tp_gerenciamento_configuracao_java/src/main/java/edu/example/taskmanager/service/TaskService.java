package edu.example.taskmanager.service;

import edu.example.taskmanager.model.Task;
import edu.example.taskmanager.storage.InMemoryStorage;
import java.util.List;

public class TaskService {
    private final InMemoryStorage store = new InMemoryStorage();

    public Task createTask(String title, boolean done) {
        return store.add(title, done);
    }

    public List<Task> listTasks() {
        return store.all();
    }

    public Task toggleTask(int id) {
        return store.toggle(id);
    }

    public void clear() {
        store.clear();
    }
}
