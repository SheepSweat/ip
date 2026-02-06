public class Parser {
    public static Task parse(String input) throws Exception {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String arguments = (parts.length > 1) ? parts[1] : "";

        switch (command.toLowerCase()) {
        case "todo":
            if (arguments.isEmpty()) throw new Exception("The description of a todo cannot be empty.");
            return new ToDo(arguments);
        case "deadline":
            if (arguments.isEmpty()) throw new Exception("The description of a deadline cannot be empty.");
            String deadline = arguments.trim();
            String[] parts2 = deadline.split("/by");
            String deadlineDescription = parts2[0];
            String day = parts2[1];
            return new Deadline(deadlineDescription, day);
        case "event":
            if (arguments.isEmpty()) throw new Exception("The description of a event cannot be empty.");
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
}
