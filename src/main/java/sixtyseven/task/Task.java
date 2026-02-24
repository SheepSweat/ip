package sixtyseven.task;
/**
 * Represents a generic task in the Sixty_Seven application.
 * This is an abstract class that provides the foundation for specific task types
 * like ToDo, Deadline, and Event.
 */
public class Task {
    /** The description of the task. */
    protected String description;
    /** The type identifier of the task. */
    protected String command;
    /** The completion status of the task. */
    protected boolean isDone;
    /**
     * Initializes a new Task with the given description.
     * By default, the task is marked as not done.
     *
     * @param description The text describing the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    /**
     * Returns the visual status icon of the task.
     *
     * @return "[X]" if the task is done, "[ ]" otherwise.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }
    /**
     * Returns the description of the task.
     *
     * @return The task description string.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns the completion status of the task.
     *
     * @return true if the task is marked as done, false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }
    /**
     * Marks the task as completed.
     */
    public void setIsDone() {
        this.isDone = true;
    }
    /**
     * Stores the original command string for this task.
     * Useful for formatting the data correctly when saving to a file.
     *
     * @param description The raw command string.
     */
    public void setCommand(String description) {
        this.command = description;
    }
    /**
     * Marks the task as incomplete.
     */
    public void setIsUndone() {
        this.isDone = false;
    }
    /**
     * Returns the icon representing the type of task.
     * This should be overridden by subclasses.
     *
     * @return A string icon like "[T]", "[D]", or "[E]".
     */
    public String getTypeIcon(){return("[?]");};;
    /**
     * Returns a string representation of the task for terminal display.
     * Includes the type icon, status icon, and description.
     *
     * @return A formatted string for UI display.
     */
    public String toString(){
        return getTypeIcon()+getStatusIcon()+ " " + description;
    }
    /**
     * Formats the task into a specific string format for file storage.
     *
     * @return A string formatted as "status | command" for saving to disk.
     */
    public String toSaveString() {
        int status = this.isDone ? 1 : 0;
        return status + " | " + this.command;
    }
}
