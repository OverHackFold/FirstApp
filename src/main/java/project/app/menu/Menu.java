package project.app.menu;

import project.app.dao.TaskRepository;
import project.app.dao.impl.TaskRepositoryJDBCImpl;
import project.app.model.Task;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final TaskRepository taskRepository;

    private final Scanner scanner = new Scanner(System.in);

    private boolean active = true;

    public void viewMenu() {
        while (active) {
            System.out.println("\n1.View tasks\n2.Add task \n3.Delete task\n4.Choose task to edit\n5.Task status\n6.Exit");
            switch (getUserChoice()) {
                case 1 -> showTasks();
                case 2 -> fillTaskData();
                case 3 -> deleteTask();
                case 4 -> editTask();
                case 5 -> editTaskStatus();
                case 6 -> active = false;
                default -> System.out.println("Choice another variant!");
            }
        }
    }

    public void fillTaskData() {
        Task task = new Task();
        System.out.println("Enter the name of the task:");
        task.setName(scanner.next());
        System.out.println("Enter a task:");
        scanner.nextLine();
        task.setTask(scanner.nextLine());
        taskRepository.save(task);
    }

    public void showTasks() {
        List<Task> tasksList = taskRepository.getAll();
        for (Task tasks : tasksList) {
            System.out.println(tasks);
        }
    }

    public void deleteTask() {
        showTasks();
        System.out.println("Choose task which you want to delete (id): ");
        Integer deletedId = scanner.nextInt();
        taskRepository.deleteByID(deletedId);
    }

    public void editTask() {
        showTasks();
        System.out.println("Choose task which you want to edit (id): ");
        Integer chosenTaskId = scanner.nextInt();
        taskRepository.editTask(chosenTaskId);
    }

    public void editTaskStatus() {
        showTasks();
        taskRepository.editStatus();

    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public Menu(TaskRepositoryJDBCImpl taskRepository) {
        this.taskRepository = taskRepository;
    }
}
