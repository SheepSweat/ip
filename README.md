# Sixty_seven project template

Sixty_seven is a task manager chatbot that helps you track your todos, deadlines, and events

## Quick Start

1. Ensure you have **Java 11 or above** installed.
2. Download `Sixty_seven.jar` from the latest release.
3. Open a terminal in the folder containing the jar file.
4. Run: `java -jar Sixty_Seven.jar`
5. Type a command and press Enter.

## Task Management
Sixty_Seven supports three distinct task types to categorize your workload:

Todo: Basic tasks without a specific timeline.

Deadline: Tasks that need to be done before a specific date/time.

Event: Tasks that occur during a specific time frame.

## Features
### Listing all tasks: `list`
Shows all tasks currently stored in your list with their status icons and types.

**Format**: list

### Adding a Todo: `todo`
Adds a task without any date constraints.

**Format**: todo DESCRIPTION

**Example**: todo finish CS2113 implementation

### Adding a Deadline: `deadline`
Adds a task with a "by" date.

**Format**: deadline DESCRIPTION /by DATE

**Example**: deadline submit lab report /by Sunday 2359

### Adding an Event: `event`
Adds a task with a start and end time.

**Format**: event DESCRIPTION /from START_TIME /to END_TIME

**Example**: event Career Fair /from 2pm /to 5pm

### Marking/Unmarking Tasks: `mark` / `unmark`
Updates the completion status of a specific task.

**Format**: mark INDEX or unmark INDEX

**Example**: mark 1 (Marks the first task in the list as done).

### Deleting a Task: `delete`
Removes a task from the list permanently.

**Format**: delete INDEX

### Exiting the program: `bye`
Exits the application.

**Format**: bye


