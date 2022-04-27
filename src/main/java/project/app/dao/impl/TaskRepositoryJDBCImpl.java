package project.app.dao.impl;

import project.app.dao.TaskRepository;
import project.app.model.Task;

import java.sql.*;
import java.util.List;

public class TaskRepositoryJDBCImpl implements TaskRepository {

    private static final String DB_URL = "jdbc:postgresql://localhost:5433/ListRepository";
    private static final String USER = "postgres";
    private static final String PASS = "123";

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
    }

    @Override
    public void save(Task task) {
        String SQL = "INSERT INTO Task (name,task,status) "
                + "VALUES(?,?,?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement prepareStatement = connection.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS);) {


            long id = 0;

            prepareStatement.setString(1, task.getName());
            prepareStatement.setString(2, task.getTask());
            prepareStatement.setString(3, task.getStatus());
            prepareStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

    }

    @Override
    public void deleteByID() {

    }

    @Override
    public void editTask() {

    }

    @Override
    public void editStatus() {

    }

    @Override
    public List<Task> getAll() {
        return null;
    }
}
