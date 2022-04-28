package project.app.dao.impl;

import project.app.dao.TaskRepository;
import project.app.dao.converter.Converter;
import project.app.model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskRepositoryJDBCImpl implements TaskRepository {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5433/taskdb";
    private static final String USER = "postgres";
    private static final String PASS = "123";

    private static Scanner scanner = new Scanner(System.in);

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
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void editTask(Integer id) {
        System.out.println("\n1.Edit task name\n2.Edit task \n3.Edit task status");
        switch (getUserChoice()) {

            case 1 -> editTaskName(id);
            case 2 -> editTaskTask(id);
            case 3 -> editTaskStatus(id);
            default -> System.out.println("You choose wrong number");
        }
    }

    public void editTaskName(Integer id) {
        String updatingTaskNameSQL = "UPDATE TASKS SET name = ?   where id = ?";
        String updatedTaskName = scanner.next();
        try (Connection connection = initDatabase()) {
            PreparedStatement preparedStatement = connection.prepareStatement(updatingTaskNameSQL);
            preparedStatement.setString(1, updatedTaskName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editTaskTask(Integer id) {
        String updateTaskTaskSQl = "UPDATE TASK SET task = ? where id = ?";
        String updataTaskTask = scanner.next();
        try(Connection connection = initDatabase()){
            PreparedStatement preparedStatement = connection.prepareStatement(updateTaskTaskSQl);
            preparedStatement.setString(1,updataTaskTask);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void editTaskStatus(Integer id) {
        String updateTaskStatusSQL = "UPDATE TASK SET status = ? where id = ?";
        String updateTaskStatus = scanner.next();
        try(Connection connection = initDatabase()){
            PreparedStatement preparedStatement = connection.prepareStatement(updateTaskStatusSQL);
            preparedStatement.setString(1,updateTaskStatus);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasksList;
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }
}
