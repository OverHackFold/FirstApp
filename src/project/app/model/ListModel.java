package project.app.model;

public class ListModel {
    private int id;
    private String name;
    private String task;


    public ListModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "ListOfTasks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", task='" + task + '\'' +
                '}';
    }


}
