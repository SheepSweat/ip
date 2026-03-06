package sixtyseven;
import java.util.ArrayList;
import java.util.Scanner;

import sixtyseven.task.Task;

/**
 * User interface class to handle reading and printing to terminal.
 */
public class Ui {
    private Scanner scanner;
    /**
     * Initializes a new Ui object with a Scanner to read system input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }
    /**
     * Reads the next line of input from the user.
     * * @return The string entered by the user, or an empty string if no line exists.
     */
    public String readCommand(){
        if(scanner.hasNextLine()){
            return scanner.nextLine();
        }
        return "";
    }
    /**
     * Prints a horizontal divider line to the terminal for visual clarity.
     */
    public void showLine(){
        System.out.println( "____________________________________________________________");
    }
    /**
     * Prints the exit message to the user.
     */
    public void showEnding(){
        System.out.println(" Bye. Hope to see you again soon!\n");
    }
    /**
     * Prints the welcome message and branding to the terminal.
     */
    public void showWelcome() {
        showLine();
        System.out.println("Hello! I'm Sixty_Seven");
        System.out.println("What can I do for you?");
        showLine();
    }
    /**
     * Displays a confirmation message when a task is successfully added.
     * @param taskInfo The string representation of the added task.
     * @param numberOfTasks The current total number of tasks in the list.
     */
    public void showTaskAdded(String taskInfo, int numberOfTasks){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskInfo);
        System.out.printf("Now you have %d tasks in the list.%n", numberOfTasks);
    }
    /**
     * Displays a confirmation message when a task is removed.
     * @param taskInfo The string representation of the deleted task.
     * @param numberOfTasks The remaining total number of tasks in the list.
     */
    public void showTaskDeleted(String taskInfo, int numberOfTasks){
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskInfo);
        System.out.printf("Now you have %d tasks in the list.%n", numberOfTasks);
    }
    /**
     * Displays a message confirming a task has been marked as completed.
     * @param taskInfo The string representation of the marked task.
     */
    public void showTaskMarked(String taskInfo){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskInfo);
    }
    /**
     * Displays a message confirming a task has been unmarked.
     * @param taskInfo The string representation of the unmarked task.
     */
    public void showTaskUnmarked(String taskInfo){
        System.out.println(" OK, I've marked this task as not done yet:");
        System.out.println(taskInfo);
    }
    /**
     * Prints a simple confirmation of an added task string.
     * @param taskInfo The raw info of the task added.
     */
    public void showSimpleAdding(String taskInfo){
        System.out.println("added: " + taskInfo);
    }
    /**
     * Displays an error message to the user with a stylized prefix.
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(" ☹ OOPS!!! " + message);
    }
    /**
     * Prints all tasks currently in the task list.
     * @param taskList The list of tasks to be displayed.
     */
    public void showList(ArrayList<Task> taskList){
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(Integer.toString(i + 1) + "." + taskList.get(i).toString());
        }
    }
    /**
     * Searches for and displays tasks that contain the specified keyword in their description.
     * @param taskList The list of tasks to search through.
     * @param input The keyword used for searching.
     */
    public void showFind(ArrayList<Task> taskList, String input){
        System.out.println("Here are the matching tasks in your list:");
        int displayNumber = 0;
        for (Task task : taskList) {
            if (task.getDescription().contains(input)) {
                displayNumber++;
                System.out.println(Integer.toString(displayNumber) + "." + task.toString());
            }
        }
    }
}
