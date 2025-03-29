import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.loadTasksFromFile("tasks.txt");
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== TASK TRACKER SYSTEM ===");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    Task newTask = new Task(taskName);
                    manager.addTask(newTask);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    manager.listTasks();
                    break;
                case 3:
                    System.out.println("Enter  task number to complete:  ");
                    int index=scanner.nextInt() -1;
                    manager.completeTask(index);
                    System.out.println("Task completed successfully.");
                    break;

                case 4:
                    System.out.println("Enter  task number to remove:  ");
                    int indexnum=scanner.nextInt() -1;
                    manager.removeTask(indexnum);
                    System.out.println("Task removed successfully.");
                    break;

                case 5:
                    manager.saveTasksToFile("tasks.txt");
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        }
        scanner.close();


    }
}
