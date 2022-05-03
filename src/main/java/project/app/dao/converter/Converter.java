package project.app.dao.converter;

import project.app.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Converter {

    public static Task toTaskFromResultSet(ResultSet resultSet) {
        Task task = new Task();
        try {
            task.setId(resultSet.getInt("id"));
            task.setName(resultSet.getString("name"));
            task.setTask(resultSet.getString("task"));
            task.setStatus(resultSet.getString("status"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return task;
    }
}

