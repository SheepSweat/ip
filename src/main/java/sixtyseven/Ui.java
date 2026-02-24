package sixtyseven;
import java.util.ArrayList;
import java.util.Scanner;

import sixtyseven.task.Task;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand(){
        if(scanner.hasNextLine()){
            return scanner.nextLine();
        }
        return "";
    }

    public void showLine(){
        System.out.println( "____________________________________________________________");
    }

    public void showEnding(){
        System.out.println(" Bye. Hope to see you again soon!\n");
    }

    public void showWelcome() {
        showLine();
        System.out.println("Hello! I'm Sixty_Seven");
        System.out.println("What can I do for you?");
        showLine();
    }

    public void showTaskAdded(String taskInfo, int numberOfTasks){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskInfo);
        System.out.printf("Now you have %d tasks in the list.%n", numberOfTasks);
    }

    public void showTaskDeleted(String taskInfo, int numberOfTasks){
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskInfo);
        System.out.printf("Now you have %d tasks in the list.%n", numberOfTasks);
    }

    public void showTaskMarked(String taskInfo){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskInfo);
    }

    public void showTaskUnmarked(String taskInfo){
        System.out.println(" OK, I've marked this task as not done yet:");
        System.out.println(taskInfo);
    }

    public void showSimpleAdding(String taskInfo){
        System.out.println("added: " + taskInfo);
    }

    public void showError(String message) {
        System.out.println(" ☹ OOPS!!! " + message);
    }

    public void showList(ArrayList<Task> taskList, int numberOfTasks){
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println(Integer.toString(i + 1) + "." + taskList.get(i).toString());
        }
    }
}
