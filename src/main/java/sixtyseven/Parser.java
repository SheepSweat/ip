package sixtyseven;

import sixtyseven.Exceptions.InvalidDeadlineException;
import sixtyseven.Exceptions.InvalidEventException;
import sixtyseven.Exceptions.InvalidTodoException;
import sixtyseven.task.Deadline;
import sixtyseven.task.Event;
import sixtyseven.task.Task;
import sixtyseven.task.ToDo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Translates user input strings into actionable Task objects.
 * Handles the decomposition of command strings and validates their structure.
 */
public abstract class Parser {

    /**
     * Parses the full user input and returns the corresponding Task object.
     * @param input The raw input string provided by the user.
     * @return A specific subclass of Task (ToDo, Deadline, or Event).
     * @throws Exception If the command is unrecognized or the input format is invalid.
     */
    public static Task parse(String input) throws Exception {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String arguments = (parts.length > 1) ? parts[1] : "";

        switch (command.toLowerCase()) {
        case "todo":
            validateTodoInput(arguments);
            return new ToDo(arguments);
        case "deadline":
            validateDeadlineInput(arguments);
            String deadline = arguments.trim();
            String[] parts2 = deadline.split("/by");
            String deadlineDescription = parts2[0];
            String day = parts2[1];
            String dayFormatted =convertDateFormatter(day);
            return new Deadline(deadlineDescription, dayFormatted);
        case "event":
            validateEventInput(arguments);
            int fromIndex = arguments.indexOf("/from");
            int toIndex = arguments.indexOf("/to");
            String eventDescription = arguments.substring(0, fromIndex).trim();
            String from = arguments.substring(fromIndex + 5, toIndex).trim();
            String to = arguments.substring(toIndex + 3).trim();
            return new Event(eventDescription, from, to);
        default:
            throw new Exception("I'm sorry, but I don't know what that means :-(");
        }
    }
    /**
     * Validates that the arguments for a ToDo command are not empty.
     * @param arguments The description part of the command.
     * @throws InvalidTodoException If the description is missing.
     */
    public static void validateTodoInput (String arguments) throws InvalidTodoException {
        if (arguments.isEmpty()) throw new InvalidTodoException();
    }
    /**
     * Validates the structure of a Deadline command.
     * Checks for a non-empty description and the presence of the "/by" delimiter.
     * @param arguments The description and date part of the command.
     * @throws InvalidDeadlineException If the description or the "/by" keyword is missing.
     */
    public static void validateDeadlineInput (String arguments) throws InvalidDeadlineException {
        if (arguments.isEmpty()) throw new InvalidDeadlineException();
        if (!arguments.contains("/by")) throw new InvalidDeadlineException();
    }
    /**
     * Validates the structure of an Event command.
     * Checks for a non-empty description and both "/from" and "/to" delimiters.
     * @param arguments The description and time range part of the command.
     * @throws InvalidEventException If the description or necessary keywords are missing.
     */
    public static void validateEventInput (String arguments) throws InvalidEventException {
        if (arguments.isEmpty()) throw new InvalidEventException();
        if(!arguments.contains("/from") && !arguments.contains("/to")) throw new InvalidEventException();
    }
    /**
     * Attempts to convert a date string from YYYY-MM-DD format to MMM dd yyyy format.
     * If the input does not match the expected date format, the original string is returned.
     * @param input The date string extracted from user input.
     * @return A formatted date string (e.g., " Feb 25 2026") or the original input if parsing fails.
     */
    public static String convertDateFormatter(String input) {
        try {
            LocalDate localDate = LocalDate.parse(input, DateTimeFormatter.ofPattern(" yyyy-MM-dd"));
            return localDate.format(DateTimeFormatter.ofPattern(" MMM dd yyyy"));
        }catch(DateTimeParseException e){
            return input;
        }
    }
}
