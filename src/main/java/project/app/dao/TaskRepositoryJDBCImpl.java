package project.app.dao;

import project.app.model.Task;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TaskRepositoryJDBCImpl implements TaskRepository {
   private static final String DB_URL = "jdbc:postgresql://localhost:5433/ListRepository";
    private static final String USER = "postgres";
    private  static final String PASS = "123";

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
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement()) {
          


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
