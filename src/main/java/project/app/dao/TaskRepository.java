package project.app.dao;

import project.app.model.Task;
import java.util.List;

public interface TaskRepository {


    void save(Task task);

    void deleteByID(Integer deletedId);

    void editTask(Task task);

    List<Task> getAll();

}
