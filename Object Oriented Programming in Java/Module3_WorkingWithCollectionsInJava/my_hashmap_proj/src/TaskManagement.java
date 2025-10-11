import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskManagement {
    public static void main(String s[]) {
        try {
            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Task> taskBook = new HashMap<>();

            // Infinite loop to keep the program running until the user chooses to exit
            while (true) {
                // Display the menu options to the user
                System.out.println(
                    "Press 1 to add an entry in the Taskbook," +
                    "\n2 to view all the tasks" +
                    "\n3 to search for tasks with name" +
                    "\n4 to update the status of the task" +
                    "\n5 to delete a task" +
                    "\n6 to sort the tasks by name" +
                    "\n7 to write the tasks onto a file" +
                    "\nAny other key to exit");

                // Read the user's choice
                String userAction = scanner.nextLine();

                // Option 1: Add a name-number entry to the phonebook
                if (userAction.equals("1")) {
                    // Prompt the user to enter the task
                    System.out.println("Enter a task");
                    String name = scanner.nextLine();
                    // Check if the name already exists in the taskBook
                    if (taskBook.containsKey(name)) {
                        System.out.println("This task already exists! Do you want to replace it? y/n");
                        String repChoice = scanner.nextLine();
                        // If the user chooses not to replace, skip to the next iteration
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    // Prompt the user to enter the phone number
                    System.out.println("Enter the Task description");
                    String description = scanner.nextLine();
                    // Prompt the user to enter the priority of the task
                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    // Validate the priority input (default to 1 if invalid)
                    priority = priority > 3 ? 1 : priority;

                    taskBook.put(name, new Task(name, description, priority));
                    System.out.println("The task has been added to the taskBook.");
                }
                // Option 2: View all the entries in the taskBook
                else if (userAction.equals("2")) {
                    // Iterate through the taskBook and print all name-task pairs
                    for (String name : taskBook.keySet()) {
                        System.out.println(name + ": " + taskBook.get(name));
                    }
                }
                // Option 3: Search for an entry by taskName
                else if (userAction.equals("3")) {
                    // Prompt the user to enter the taskName to search
                    System.out.println("Enter the taskName you want to search");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (taskBook.containsKey(keyName)) {
                        // Display the task associated with the name
                        System.out.println(taskBook.get(keyName));
                    } else {
                        System.out.println("No such task found in the taskbook.");
                    }
                }
                // Option 4: Update a task by name
                else if (userAction.equals("4")) {
                    // Prompt the user to enter the taskName to update
                    System.out.println("Enter the name of the task you want to update ");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (taskBook.containsKey(keyName)) {
                        // Prompt the user to enter the new status for the task
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'Completed'");
                        String updatedStatus = scanner.nextLine();

                        // Update the task status based on user input
                        if (updatedStatus.equalsIgnoreCase("P")) {
                            taskBook.get(keyName).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            taskBook.get(keyName).setStatus(Task.COMPLETED);
                        }

                        System.out.println("The task has been updated.");
                    } else {
                        System.out.println("No such task found in the taskbook.");
                    }
                }
                // Option 5: Delete a task by name
                else if (userAction.equals("5")) {
                    // Prompt the user to enter the name to delete
                    System.out.println("Enter the name you want to delete ");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the taskBook
                    if (taskBook.containsKey(keyName)) {
                        // Remove the entry from the HashMap
                        taskBook.remove(keyName);
                        System.out.println("The task has been removed.");
                    } else {
                        System.out.println("No such task found in the taskBook.");
                    }
                }
                // Option 6: Sort the entries by taskName
                else if (userAction.equals("6")) {
                    // Sort the taskBook by keys using TreeMap
                    TreeMap taskBookTreeMap = new TreeMap<String,Task>(taskBook);
                    for (Object keyName : taskBookTreeMap.keySet()) {
                        System.out.println(keyName + ": " + taskBookTreeMap.get((String)keyName));
                    }
                }
                // Option 7: Write the entries to a text file
                else if (userAction.equals("7")) {
                    // Write the taskBook entries to a file
                    try (PrintWriter writer = new PrintWriter(new FileWriter("taskBook.txt"))) {
                        for (String name : taskBook.keySet()) {
                            writer.println(name + ": " + taskBook.get(name)+"\n\n");
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                }
                // Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            // Handle invalid number input (for example, non-integer input for priority or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}