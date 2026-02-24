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
import java.time.temporal.ChronoUnit;

public class Parser {
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

    public static void validateTodoInput (String arguments) throws InvalidTodoException {
        if (arguments.isEmpty()) throw new InvalidTodoException();
    }

    public static void validateDeadlineInput (String arguments) throws InvalidDeadlineException {
        if (arguments.isEmpty()) throw new InvalidDeadlineException();
        if (!arguments.contains("/by")) throw new InvalidDeadlineException();
    }

    public static void validateEventInput (String arguments) throws InvalidEventException {
        if (arguments.isEmpty()) throw new InvalidEventException();
        if(!arguments.contains("/from") && !arguments.contains("/to")) throw new InvalidEventException();
    }

    public static String convertDateFormatter(String input) {
        try {
            LocalDate localDate = LocalDate.parse(input, DateTimeFormatter.ofPattern(" yyyy-MM-dd"));
            return localDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        }catch(DateTimeParseException e){
            return input;
        }
    }
}
