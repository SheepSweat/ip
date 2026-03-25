# Sixty_seven project template

Sixty_seven is a task manager chatbot that helps you track your todos, deadlines, and events

## Quick Start

1. Ensure you have Java 11 or above installed.
2. Download Sixty_seven.jar from the latest release.
3. Open a terminal in the folder containing the jar file.
4. Run: java -jar Sixty_seven.jar
5. Type a command and press Enter.

## Task Management
Sixty_Seven supports three distinct task types to categorize your workload:

Todo: Basic tasks without a specific timeline.

Deadline: Tasks that need to be done before a specific date/time.

Event: Tasks that occur during a specific time frame.

## Features
### Listing all tasks: list
Shows all tasks currently stored in your list with their status icons and types.

Format: list

### Adding a Todo: todo
Adds a task without any date constraints.

Format: todo DESCRIPTION

Example: todo read book

### Adding a Deadline: deadline
Adds a task with a "by" date.

Format: deadline DESCRIPTION /by DATE

Example: deadline return book /by Sunday

### Adding an Event: event
Adds a task with a start and end time.

Format: event DESCRIPTION /from START_TIME /to END_TIME

Example: event project meeting /from Mon 2pm /to 4pm

### Marking/Unmarking Tasks: mark / unmark
Updates the completion status of a specific task.

Format: mark INDEX or unmark INDEX

Example: mark 1 (Marks the first task in the list as done).

### Deleting a Task: delete
Removes a task from the list permanently.

Format: delete INDEX

### Finding a Task: find
Finds a task with the corresponding keyword

Format: find KEYWORD 

Example: find book 

### Exiting the program: bye
Exits the application.

Format: bye

## Command Summary
| Action | Format, Examples |
| :--- | :--- |
| **Todo** | `todo DESCRIPTION`<br>e.g., `todo read book` |
| **Deadline** | `deadline DESCRIPTION /by DATETIME`<br>e.g., `deadline return book /by Sunday` |
| **Event** | `event DESCRIPTION /from START /to END`<br>e.g., `event project meeting /from Mon 2pm /to 4pm` |
| **List** | `list` |
| **Mark** | `mark INDEX`<br>e.g., `mark 1` |
| **Unmark** | `unmark INDEX`<br>e.g., `unmark 1` |
| **Delete** | `delete INDEX`<br>e.g., `delete 2` |
| **Find** | `find KEYWORD`<br>e.g., `find book` |
| **Bye** | `bye` |