package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Manages a collection of Task objects. @author Your Name */
public class TaskManager {

    private Map<String, Task> tasks;

    /** Constructs an empty TaskManager. */
    public TaskManager() {
        tasks = new LinkedHashMap<>();
    }

    /** @param task task to add @throws IllegalArgumentException if duplicate ID */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /** @param taskId ID to search @return Task or null if not found */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /** @param status status to filter by @return list of matching tasks */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}