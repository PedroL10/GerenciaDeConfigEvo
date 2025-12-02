package edu.example.taskmanager.storage;

import edu.example.taskmanager.model.Task;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryStorage {
    private final Map<Integer, Task> items = new LinkedHashMap<>();
    private final AtomicInteger next = new AtomicInteger(1);

    public synchronized Task add(String title, boolean done) {
        int id = next.getAndIncrement();
        Task t = new Task(id, title, done);
        items.put(id, t);
        return t;
    }

    public synchronized Task get(int id) {
        return items.get(id);
    }

    public synchronized List<Task> all() {
        return new ArrayList<>(items.values());
    }

    public synchronized Task toggle(int id) {
        Task t = items.get(id);
        if (t == null) return null;
        t.setDone(!t.isDone());
        return t;
    }

    public synchronized void clear() {
        items.clear();
        next.set(1);
    }
}
