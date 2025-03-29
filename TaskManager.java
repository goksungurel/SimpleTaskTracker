import java.util.ArrayList;
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
}
