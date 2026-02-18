import java.util.Scanner;

import sixtyseven.Exceptions.EmptyDescriptionException;
import sixtyseven.Exceptions.EmptyTaskNumberException;
import sixtyseven.Exceptions.InvalidCommandException;
import sixtyseven.Exceptions.InvalidTaskNumberException;
import sixtyseven.Exceptions.Sixty_SevenException;
import sixtyseven.task.Task;
import sixtyseven.Parser;

public class Sixty_Seven {
    private static final int MAX_TASKS = 100;
    private static final int NUM_OF_DASH_LINE = 60;
    public static void printEnding(){
        //printLine();
        System.out.println(" Bye. Hope to see you again soon!\n");
        printLine();
    }
    
    public static void printLine(){
        System.out.println( "____________________________________________________________");
    }

    public static void availableTasks(int numberOfTasks){
        if(numberOfTasks>=MAX_TASKS)
        {
            System.out.println("Too many tasks!");
        }
    }

    public static void validateInput(String input)throws EmptyDescriptionException {
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        }
    }

    public static void validateNumberedInput(String[] input, int numberOfTasks) throws EmptyTaskNumberException, InvalidTaskNumberException {
        if(input.length<2){
            throw new EmptyTaskNumberException();
        } else if ((Integer.parseInt(input[1])>numberOfTasks)) {
            throw new InvalidTaskNumberException();
        }
    }



    private static void loop(Scanner input)throws Exception {
        Task[] taskList = new Task[MAX_TASKS];
        int numberOfTasks = 0;
        int taskId;

            while (true) {
                try {
                String echoedLine = input.nextLine();
                printLine();
                String[] parts = echoedLine.split(" ", 2);
                String command = parts[0];
                validateInput(command.toLowerCase());
                switch (command.toLowerCase()) {
                case "list":
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < numberOfTasks; i++) {
                        System.out.println(Integer.toString(i + 1) + "." + taskList[i].toString());
                    }
                    break;
                case "add":
                    availableTasks(numberOfTasks);
                    taskList[numberOfTasks] = new Task(echoedLine);
                    System.out.println("added: " + echoedLine);
                    numberOfTasks++;
                    break;
                case "mark":
                    validateNumberedInput(parts,numberOfTasks);
                    taskId = Integer.parseInt(parts[1]);
                    taskList[taskId - 1].setIsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + taskList[taskId - 1].getStatusIcon() + " " + taskList[taskId - 1].getDescription());
                    break;
                case "unmark":
                    validateNumberedInput(parts,numberOfTasks);
                    taskId = Integer.parseInt(parts[1]);
                    taskList[taskId - 1].setIsUndone();
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("  " + taskList[taskId - 1].getStatusIcon() + " " + taskList[taskId - 1].getDescription());
                    break;

                case "bye":
                    printEnding();
                    return;
                case "deadline":
                case "event":
                case "todo":
                    availableTasks(numberOfTasks);
                    taskList[numberOfTasks] = Parser.parse(echoedLine);
                    numberOfTasks++;
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskList[numberOfTasks - 1].toString());
                    System.out.printf("Now you have %d tasks in the list.%n", numberOfTasks);
                    break;
                case "delete":
                    validateNumberedInput(parts,numberOfTasks);
                    taskId = Integer.parseInt(parts[1]);
                    Task taskToDelete = taskList[taskId - 1];
                    for ( int i = taskId-1; i < numberOfTasks-1; i++ ) {
                        taskList[i]=taskList[i+1];
                    }
                    taskList[numberOfTasks-1] = null;
                    numberOfTasks--;
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(taskToDelete.toString());
                    System.out.printf("Now you have %d tasks in the list.%n", numberOfTasks);
                    break;

                default:
                    throw new InvalidCommandException();
                }
                printLine();
            }catch (Sixty_SevenException e){
                    System.out.println(e.getMessage());
                    printLine();
                }
        }

    }


    private static void startSeq() {
        printLine();
        System.out.println("Hello! I'm Sixty_Seven");
        System.out.println("What can I do for you?");
        printLine();
    }

    public static void main(String[] args) throws Exception {
        startSeq();
        Scanner input = new Scanner(System.in);
        loop(input);
    }
}