package sixtyseven.task;

public class Task {
    protected String description;
    protected String Type;
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
}
