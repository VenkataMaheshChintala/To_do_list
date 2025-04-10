public class Task {
    String name;
    public boolean isDone;

    public Task(String name) {
        this.name = name;
        isDone = false;
    }

    public Task(String name,Boolean status) {
        this.name = name;
        this.isDone = status;
    }

    public String toString() {
        return isDone+";"+name;
    }

    public static Task fromFile(String line) {
        String[] task = line.split(";",2);
        return new Task(task[1],Boolean.parseBoolean(task[0]));
    }

}
