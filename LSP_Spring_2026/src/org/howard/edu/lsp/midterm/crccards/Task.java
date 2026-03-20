package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a single task in the task management system.
 * Each task has a unique ID, a description, and a status that tracks its progress.
 * @author Your Name
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a new Task with the specified ID and description.
     * The status is automatically set to OPEN when a task is created.
     * @param taskId the unique identifier for this task
     * @param description a brief description of what the task involves
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the unique identifier for this task.
     * @return the task ID string
     */
    public String getTaskId() { return taskId; }

    /**
     * Returns the description of what this task involves.
     * @return the task description string
     */
    public String getDescription() { return description; }

    /**
     * Returns the current status of this task.
     * Possible values are OPEN, IN_PROGRESS, COMPLETE, or UNKNOWN.
     * @return the current status string
     */
    public String getStatus() { return status; }

    /**
     * Updates the status of this task to the specified value.
     * Valid status values are OPEN, IN_PROGRESS, and COMPLETE.
     * Status comparisons are case-sensitive. If an invalid value is provided,
     * the status will be set to UNKNOWN.
     * @param status the new status value to assign to this task
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns a formatted string representation of this task.
     * The format is: taskId description [status]
     * For example: T1 Write report [OPEN]
     * @return a string representing this task in the required format
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}