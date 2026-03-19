package org.howard.edu.lsp.midterm.crccards;

/** Represents a task with an ID, description, and status. @author Your Name */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /** @param taskId unique ID @param description task description */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /** @return task ID */
    public String getTaskId() { return taskId; }

    /** @return description */
    public String getDescription() { return description; }

    /** @return status */
    public String getStatus() { return status; }

    /** @param status OPEN, IN_PROGRESS, or COMPLETE — anything else sets UNKNOWN */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /** @return taskId description [status] */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}