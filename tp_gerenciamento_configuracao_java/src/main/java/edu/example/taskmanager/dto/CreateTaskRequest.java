package edu.example.taskmanager.dto;

public class CreateTaskRequest {
    private String title;
    private Boolean done;

    public CreateTaskRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Boolean getDone() { return done; }
    public void setDone(Boolean done) { this.done = done; }
}
