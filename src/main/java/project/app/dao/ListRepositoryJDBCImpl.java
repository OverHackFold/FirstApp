package project.app.dao;

import project.app.model.ListModel;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListRepositoryJDBCImpl implements ListRepository {
    //  Database credentials
   private static final String DB_URL = "jdbc:postgresql://localhost:5433/ListRepository";
    private static final String USER = "postgres";
    private  static final String PASS = "123";

    public static void main(String[] argv) {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    @Override
    public void save(ListModel list) {

    }

    @Override
    public void deleteByID() {

    }

    @Override
    public void getByName() {

    }

    @Override
    public void listSE() {

    }

    @Override
    public List<ListModel> getAll() {
        return null;
    }
}
