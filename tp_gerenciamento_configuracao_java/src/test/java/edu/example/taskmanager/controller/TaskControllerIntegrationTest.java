package edu.example.taskmanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHealth() throws Exception {
        mockMvc.perform(get("/api/health"))
            .andExpect(status().isOk());
    }
}
