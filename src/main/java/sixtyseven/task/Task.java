package sixtyseven.task;

public class Task {
    protected String description;
    protected String Type;
    protected String command;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone() {
        this.isDone = true;
    }

    public void setCommand(String description) {
        this.command = description;
    }

    public void setIsUndone() {
        this.isDone = false;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getTypeIcon(){
        return("[?]");
    }

    public String toString(){
        return getTypeIcon()+getStatusIcon()+ " " + description;
    }

    public String toSaveString() {
        // We use a "|" as a separator because it's unlikely to be in your task description
        // Format: status | command
        int status = this.isDone ? 1 : 0;
        return status + " | " + this.command;
    }
}
