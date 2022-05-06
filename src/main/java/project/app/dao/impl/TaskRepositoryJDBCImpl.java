package project.app.dao.impl;

import project.app.dao.TaskRepository;
import project.app.dao.converter.Converter;
import project.app.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryJDBCImpl implements TaskRepository {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5433/taskdb";
    private static final String USER = "postgres";
    private static final String PASS = "123";

    public static Connection initDatabase() {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Task task) {
        String insertTaskToDBSQL = "INSERT INTO TASKS (name,task,status) VALUES(?,?,?)";
        try (Connection connection = initDatabase()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertTaskToDBSQL);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getTask());
            preparedStatement.setString(3, task.getStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByID(Integer deletedId) {
        String deleteTaskFromDBSQL = "DELETE FROM TASKS WHERE id = ?";
        String checkIfTasksDeleted = "SELECT * FROM TASKS WHERE id = ?";
        try(Connection connection = initDatabase()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteTaskFromDBSQL);
            preparedStatement.setInt(1, deletedId);
            preparedStatement.executeUpdate();
            PreparedStatement checkingPreparedStatement = connection.prepareStatement(checkIfTasksDeleted);
            checkingPreparedStatement.setInt(1, deletedId);
            ResultSet resultSet = checkingPreparedStatement.executeQuery();
            if(!resultSet.next()) {
                System.out.println("Task with id: "+deletedId+" , was successfully deleted.");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void editTask(Task task) {
        String updatingTask = "UPDATE TASKS SET name = ?,task =?,status =?  where id = ?";
        try (Connection connection = initDatabase()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updatingTask);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2,task.getTask());
            preparedStatement.setString(3,task.getStatus());
            preparedStatement.setInt(4,task.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





    @Override
    public List<Task> getAll() {
        List<Task> tasksList = new ArrayList<>();
        String getAllTasksFromDBSQL = "SELECT * FROM TASKS";
        try (Connection connection = initDatabase()) {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllTasksFromDBSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tasksList.add(Converter.toTaskFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasksList;
    }
}
