package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects for the task management system.
 * Uses a LinkedHashMap internally to ensure fast lookup by task ID,
 * prevent duplicate task IDs, and preserve insertion order.
 * @author Your Name
 */
public class TaskManager {

    private Map<String, Task> tasks;

    /**
     * Constructs a new TaskManager with an empty collection of tasks.
     */
    public TaskManager() {
        tasks = new LinkedHashMap<>();
    }

    /**
     * Adds a new task to the manager.
     * Each task must have a unique ID. If a task with the same ID already
     * exists in the manager, an exception is thrown to prevent duplicates.
     * @param task the Task object to add to the collection
     * @throws IllegalArgumentException if a task with the same task ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Searches for and returns a task by its unique task ID.
     * If no task with the given ID exists in the collection, null is returned.
     * @param taskId the unique identifier of the task to search for
     * @return the Task object with the matching ID, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns a list of all tasks that currently have the specified status.
     * Iterates through all tasks and collects those whose status matches
     * the provided value. The comparison is case-sensitive.
     * @param status the status value to filter tasks by (e.g. OPEN, IN_PROGRESS, COMPLETE)
     * @return a List of Task objects whose status matches the specified value
     */
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