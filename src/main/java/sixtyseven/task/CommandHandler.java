package sixtyseven.task;

import java.util.ArrayList;

import sixtyseven.Exceptions.EmptyDescriptionException;
import sixtyseven.Exceptions.EmptyTaskNumberException;
import sixtyseven.Exceptions.InvalidCommandException;
import sixtyseven.Exceptions.InvalidTaskNumberException;
import sixtyseven.Parser;

import sixtyseven.Ui;

/**
 * abstract class to handle any commands passed.
 */
public abstract class CommandHandler {
    /**
     *  Handles any command input from the user.
     *  if command is unrecognised throw and exception and exit.
     * @param input User input from keyboard.
     * @param Store Storage instance in charge of storing commands/list to txt file.
     * @param ui User interface instance in charge of printing to terminal.
     * @param taskList Array list to hold all the tasks.
     * @param filename Filepath required to store the txt file.
     * @throws Exception if command is unrecognised.
     */
    public static void handleCommand(String input, Storage Store, Ui ui, ArrayList<Task> taskList, String filename) throws Exception {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String arguments = (parts.length > 1) ? parts[1] : "";
        validateInput(command.toLowerCase());
        int taskId;
            switch (command.toLowerCase()) {
            case "list":
                ui.showList(taskList);
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

            case "find":
                ui.showFind(taskList,arguments);
                break;
            default:
                throw new InvalidCommandException();
            }
    }

    /**
     *
     * @param input String input to be validated.
     * @throws EmptyDescriptionException if there is no input.
     */
    public static void validateInput(String input) throws EmptyDescriptionException {
        if (input.isEmpty()) {
            throw new EmptyDescriptionException();
        }
    }

    /**
     *
     * @param input String array containing the TaskID to validate.
     * @param numberOfTasks total number of tasks in taskList.
     * @throws EmptyTaskNumberException if there is no number input.
     * @throws InvalidTaskNumberException if the number input is invalid.
     */
    public static void validateNumberedInput(String[] input, int numberOfTasks) throws EmptyTaskNumberException, InvalidTaskNumberException {
        if (input.length < 2 || input[1].trim().isEmpty()) {
            throw new EmptyTaskNumberException();
        } else if ((Integer.parseInt(input[1]) > numberOfTasks)) {
            throw new InvalidTaskNumberException();
        }
    }
}
