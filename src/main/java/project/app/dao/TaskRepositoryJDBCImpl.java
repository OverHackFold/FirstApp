package project.app.dao;

import project.app.model.Task;

import java.sql.*;
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
        String SQL = "INSERT INTO Task (name,task,status) "
                + "VALUES(?,?,?)";
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = connection.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);) {


            long id =0;

            pstmt.setString(1, task.getName());
            pstmt.setString(2, task.getTask());
            pstmt.setString(3,task.getStatus());
            pstmt.executeUpdate();

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {

                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }



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
