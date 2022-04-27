package project.app.menu;

import project.app.dao.TaskRepository;
import project.app.dao.impl.TaskRepositoryCollectionImpl;
import project.app.model.Task;

import java.util.List;
import java.util.Scanner;


public class Menu {


    private final TaskRepository taskRepository;
    public Menu(TaskRepositoryCollectionImpl taskRepository) {
        this.taskRepository = taskRepository;
    }
    Scanner scanner = new Scanner(System.in);


    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void viewMenu() {
        boolean active = true;
        while (active) {
            System.out.println("\n1.View tasks\n2.Add task \n3.Delete task\n4.Choice task to edit\n5.Task status\n6.Exit");
            switch (getUserChoice()) {
                case 1:
                    showTasks();
                    break;
                case 2:
                    fillTaskData();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    chooseTask();
                    break;
                case 5:
                    taskStatus();
                    break;
                case 6:
                    active = false;
                    break;
                default:
                    System.out.println("Choice another variant!");
            }
        }

    }


    public Task fillTaskData() {
        Task task = new Task();
        System.out.println("Enter the task ID:");
        task.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the name of the task:");
        task.setName(scanner.nextLine());
        System.out.println("Press space bar to continue");
        scanner.nextLine();
        System.out.println("Enter a task:");
        task.setTask(scanner.nextLine());

        taskRepository.save(task);
        return task;

    }

    public void showTasks() {
        List<Task> task = taskRepository.getAll();
        for (Task tasks : task) {
            System.out.println(tasks);
        }


    }

    public void deleteTask() {
        showTasks();
        taskRepository.deleteByID();
    }

    public void chooseTask() {
        showTasks();
        taskRepository.editTask();

    }

    public void taskStatus() {
        showTasks();
        taskRepository.editStatus();

    }


}
