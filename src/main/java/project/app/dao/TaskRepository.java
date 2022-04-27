package project.app.dao;

import project.app.model.Task;

import java.util.List;

public interface TaskRepository {

    void save(Task list);

    void deleteByID();

    void editTask();

    void editStatus();

    List<Task> getAll();
}