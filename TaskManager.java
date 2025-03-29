import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> tasks=new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(int index){
        if(index<0 || index>=tasks.size() ){
            System.out.println("Invalid index.");
        }else{
            tasks.remove(index);
            System.out.println("Task removed.");
        }

    }
    public void listTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
        }else{
            for(int i=0; i<tasks.size(); i++){
                System.out.println((i+1)+"."+tasks.get(i));
            }
        }
    }
    public void completeTask(int index){
        if(index<0 || index>=tasks.size()){
            System.out.println("Index out of bounds");
        }else{
            tasks.get(index).complete();
            System.out.println("Task completed");
        }
    }
  public void saveTasksToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Task task : tasks) {
                writer.write(task.getName() + ";" + task.isCompleted() + "\n");
            }
            System.out.println("Tasks saved to file");

        } catch (IOException e) {
            System.out.println("An error occurred while saving tasks.");
            e.printStackTrace();
        }
    }

    public void loadTasksFromFile(String filename) {
        try(Scanner reader = new Scanner(new File(filename))) {
            while(reader.hasNextLine()){
                String line=reader.nextLine();
                String[] tokens = line.split(";");
                if(tokens.length == 2){
                    String name = tokens[0];
                    boolean completed = Boolean.parseBoolean(tokens[1]);

                    Task task = new Task(name);
                    task.setCompleted(completed);
                    addTask(task);
                }

            }
            System.out.println("Tasks loaded from file");
        }catch (FileNotFoundException e) {
            System.out.println("No saved file found. Starting with an empty task list.");
        }

    }
}

