package sixtyseven.task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import sixtyseven.Exceptions.EmptyDescriptionException;
import sixtyseven.Exceptions.EmptyTaskNumberException;
import sixtyseven.Exceptions.InvalidCommandException;
import sixtyseven.Exceptions.InvalidTaskNumberException;
import sixtyseven.Exceptions.Sixty_SevenException;
import sixtyseven.Parser;

import sixtyseven.Ui;


public class CommandHandler {

    public static void handleCommand(String input, Storage Store, Ui ui, ArrayList<Task> taskList, String filename) throws Exception {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String arguments = (parts.length > 1) ? parts[1] : "";
        validateInput(command.toLowerCase());
        int taskId;
            switch (command.toLowerCase()) {
            case "list":
                ui.showList(taskList, taskList.size());
                break;
            case "add":
                Task newTask = new Task(input);
                newTask.setCommand(input);
                taskList.add(newTask);
                ui.showSimpleAdding(input);
                break;
            case "mark":
                validateNumberedInput(parts, taskList.size());
                taskId = Integer.parseInt(parts[1]);
                Task markedTask = taskList.get(taskId - 1);
                markedTask.setIsDone();
                String markedString = "  " + markedTask.getStatusIcon()
                        + " " + markedTask.getDescription();
                ui.showTaskMarked(markedString);
                Store.saveToFile(filename, taskList, taskList.size());
                break;
            case "unmark":
                validateNumberedInput(parts, taskList.size());
                taskId = Integer.parseInt(parts[1]);
                Task unmarkedTask = taskList.get(taskId - 1);
                unmarkedTask.setIsUndone();
                String unmarkedString = "  " + unmarkedTask.getStatusIcon()
                        + " " + unmarkedTask.getDescription();
                ui.showTaskUnmarked(unmarkedString);
                Store.saveToFile(filename, taskList, taskList.size());
                break;

            case "bye":
                ui.showEnding();
                return;
            case "deadline":
            case "event":
            case "todo":
                Task newComplexTask = Parser.parse(input);
                newComplexTask.setCommand(input);
                taskList.add(newComplexTask);
                String taskInfoComplexTask = newComplexTask.toString();
                ui.showTaskAdded(taskInfoComplexTask, taskList.size());
                Store.saveToFile(filename, taskList, taskList.size());
                break;

            case "delete":
                validateNumberedInput(parts, taskList.size());
                taskId = Integer.parseInt(parts[1]);
                Task taskToDelete = taskList.get(taskId - 1);
                taskList.remove(taskId - 1);
                String taskInfoDeleteTask = taskToDelete.toString();
                ui.showTaskDeleted(taskInfoDeleteTask, taskList.size());
                Store.saveToFile(filename, taskList, taskList.size());
                break;
            default:
                throw new InvalidCommandException();
            }
    }

    public static void validateInput(String input) throws EmptyDescriptionException {
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        }
    }

    public static void validateNumberedInput(String[] input, int numberOfTasks) throws EmptyTaskNumberException, InvalidTaskNumberException {
        if (input.length < 2 || input[1].trim().isEmpty()) {
            throw new EmptyTaskNumberException();
        } else if ((Integer.parseInt(input[1]) > numberOfTasks)) {
            throw new InvalidTaskNumberException();
        }
    }
}
