package project.app.model;

import java.util.Objects;

// todo Нет второй сущности TodoList
public class Task {

    private Integer id;
    private String name;
    private String task;
    private String status;

    public Task() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", task='" + task + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task1 = (Task) o;
        return getId().equals(task1.getId()) && Objects.equals(getName(), task1.getName()) && Objects.equals(getTask(), task1.getTask()) && Objects.equals(getStatus(), task1.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTask(), getStatus());
    }
}
