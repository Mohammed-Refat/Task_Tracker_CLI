# Task Tracker CLI

A command-line application to manage tasks using Java. This Task Tracker allows users to create, update, delete, and list tasks, with each task stored locally in a JSON file.

## Features

- **Add Task**: Add a new task with a description.
- **Update Task**: Update the description of an existing task.
- **Delete Task**: Remove a task by its ID.
- **List Tasks**: View all tasks, filter by status (e.g., ToDo, InProgress, Done).
- **Change Task Status**: Mark a task as "In Progress" or "Done."
- **Persistence**: Task data is saved in a local JSON file (`tasks.json`).

## Prerequisites

Before running the project, ensure you have the following installed:

- Java 17 or higher
- Git

## Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Mohammed-Refat/task_tracker_cli.git
   cd task_tracker_cli
   ```

2. **Compile the Project**

   Navigate to the `src` folder and compile the Java classes:

   ```bash
   cd src
   javac TaskTrackerApp.java Task.java TaskManager.java Status.java
   ```

3. **Run the Application**

   After compilation, you can run the application using:

   ```bash
   java TaskTrackerApp [command] [options]
   ```


## Usage

### Available Commands:

#### Add a new task:
```bash
java TaskTrackerApp add "Buy groceries"
```
**Output**: Task added successfully (ID: 1)

#### Update a task:
```bash
java TaskTrackerApp update 1 "Buy groceries and cook dinner"
```
**Output**: Task updated successfully (ID: 1)

#### Delete a task:
```bash
java TaskTrackerApp delete 1
```
**Output**: Task deleted successfully (ID: 1)

#### Mark a task as in progress:
```bash
java TaskTrackerApp mark-in-progress 1
```
**Output**: Task marked as in progress (ID: 1)

#### Mark a task as done:
```bash
java TaskTrackerApp mark-done 1
```
**Output**: Task marked as done (ID: 1)

#### List all tasks:
```bash
java TaskTrackerApp list
```
**Output**: List of all tasks

#### List tasks by status:
```bash
java TaskTrackerApp list todo
java TaskTrackerApp list in-progress
java TaskTrackerApp list done
```
**Output**: List of tasks with the specified status

---


## Project Structure

```bash
.
├── tasks.json              # Stores the tasks in JSON format
├── Task.java               # Task class with task properties and methods
├── TaskManager.java        # Manages task operations (CRUD)
└── TaskTrackerApp.java     # CLI entry point, handles command-line arguments
```

## JSON File Structure

Tasks are stored in `tasks.json` in the following format:

```json
[
  { "id": "1", "description": "Solve problem", "status": "TODO", "createdAt": "2024-09-12T10:15:30", "updatedAt": "2024-09-12T10:15:30"}
]
```

## Contributions

Feel free to fork this repository and submit a pull request with improvements or bug fixes.
