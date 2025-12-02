package edu.example.taskmanager.service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import edu.example.taskmanager.model.Task;

public class TaskServiceUnitTest {

    private TaskService service;

    @BeforeEach
    public void setup() {
        service = new TaskService();
        service.clear();
    }

    @Test
    public void testCreateAndList() {
        Task t1 = service.createTask("one", false);
        Task t2 = service.createTask("two", true);
        assertEquals(2, service.listTasks().size());
        assertEquals("one", service.listTasks().get(0).getTitle());
    }

    @Test
    public void testToggle() {
        Task t = service.createTask("abc", false);
        Task res = service.toggleTask(t.getId());
        assertTrue(res.isDone());
        Task res2 = service.toggleTask(t.getId());
        assertFalse(res2.isDone());
    }
}
