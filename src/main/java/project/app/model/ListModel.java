package project.app.model;

import java.util.Objects;

public class ListModel {

    private Integer id;
    private String name;
    private String task;
    private String status;



    public ListModel() {

    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "ListModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", task='" + task + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListModel)) return false;
        ListModel listModel = (ListModel) o;
        return Objects.equals(getId(), listModel.getId()) && Objects.equals(getName(), listModel.getName()) && Objects.equals(getTask(), listModel.getTask()) && Objects.equals(getStatus(), listModel.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTask(), getStatus());
    }
}
