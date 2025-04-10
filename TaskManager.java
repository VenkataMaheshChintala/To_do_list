import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();

    public TaskManager() {
        try {
            LoadTasksFromFile();
        } catch (Exception e) {
            System.out.println("Error while loading tasks from the file : " + e.getMessage());
        }
    }

    public void addTask(String name) {
        tasks.add(new Task(name));
        System.out.println("Task added!");
        saveToFile();
    }

    public void showTasks() {
        if(tasks.isEmpty()) {
            System.out.println("No tasks!");
            return;
        }
        for(int i=0;i< tasks.size();i++) {
            System.out.println("\nTask " + (i+1) + " : " + tasks.get(i).name);
            System.out.println("Status : " + ((tasks.get(i).isDone)?"Completed!" : "Yet to Complete\n"));
        }
    }

    public void markDone(int index) {
        if(index < 0 || index > tasks.size()) {
            System.out.println("Invalid task number!");
        } else {
            tasks.get(index).isDone = true;
            System.out.println("Marked the task as completed!");
            saveToFile();
        }
    }

    public void deleteTask(int index) {
        if(index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number!");
        } else {
            tasks.remove(index);
            System.out.println("Task successfully deleted!");
            saveToFile();
        }
    }

    public void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter("tasks.txt");
            for (Task task : tasks) {
                writer.println(task.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while saving contents to file : " + e.getMessage());
        }
    }

    public void LoadTasksFromFile() throws FileNotFoundException {
        File file = new File("tasks.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            tasks.add(Task.fromFile(line));
        }
    }

}
