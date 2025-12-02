package edu.example.taskmanager.util;

public class Utils {
    public static String normalizeTitle(String title) {
        if (title == null) return "";
        return title.trim();
    }
}
