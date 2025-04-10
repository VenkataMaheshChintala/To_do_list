import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();
        int choice;

        do {
            System.out.println("1. Add a new task\n2. Delete a task \n3. Show all tasks\n4. Mark a task as done\n5. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of your task : ");
                    String name = sc.nextLine();
                    tm.addTask(name);
                    break;
                case 2:
                    tm.showTasks();
                    System.out.print("Enter the task number to be deleted : ");
                    int del = sc.nextInt();
                    tm.deleteTask(del-1);
                    break;
                case 3:
                    tm.showTasks();
                    break;
                case 4:
                    System.out.print("Enter the task number to be marked as done : ");
                    int temp = sc.nextInt();
                    tm.markDone(temp-1);
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice!=5);
    }
}