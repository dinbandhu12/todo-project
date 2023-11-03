package com.example.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskDatabase {
    private static List<Task> tasks = new ArrayList<>();

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        tasks.add(task);
    }
}
