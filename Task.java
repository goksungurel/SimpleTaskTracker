public class Task {
    private String name;
    private boolean isCompleted;
  
    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean isCompleted(){
        return isCompleted;
    }
    public void setCompleted(boolean completed){
        isCompleted = completed;
    }

    public void complete(){
        isCompleted = true;
    }
    public String toString(){
        return (isCompleted ? "[✓] " : "[ ] ") + name;
    }

}
