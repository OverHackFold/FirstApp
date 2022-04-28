package project.app.dao.impl;

import project.app.dao.TaskRepository;
import project.app.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskRepositoryCollectionImpl implements TaskRepository {
    private final ArrayList<Task> myTask = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(Task task) {
        myTask.add(task);
        System.out.println("Task  was successfully added!");
    }

    @Override
    public void deleteByID(Integer deletedId) {
        System.out.println("Enter the ID of the task you want to delete:");
        Integer gUC = scanner.nextInt();
        for (Task tasks : myTask) {
            System.out.println(tasks);
        }
        myTask.removeIf(taskModel -> gUC.equals(taskModel.getId()));
        System.out.println("Task deleted successfully!");
    }

    @Override
    public void editTask(Integer id) {

        System.out.println("Enter the id of the task:");
        Integer gUC1 = scanner.nextInt();
        for (Task task : myTask) {
            if (gUC1.equals(task.getId())) {
                System.out.println("Select the item you would like to edit:\n1.Edit name\n2.Edit the task\n3.Edit task status");
                int gUC = scanner.nextInt();
                switch (gUC) {
                    case 1:
                        System.out.println("Enter a new name:");
                        task.setName(scanner.next());
                        System.out.println("Name successfully changed to: " + task.getName());
                        break;
                    case 2:
                        System.out.println("Enter a new task:");
                        task.setTask(scanner.nextLine());
                        System.out.println("Task was successfully edited!");
                        break;
                    case 3:
                        System.out.println("To mark a task as completed, press 1;\nTo mark a task as NOT completed, press 2;");
                        int gUc = scanner.nextInt();
                        switch (gUc) {
                            case 1:
                                task.setStatus("Finished");
                                break;
                            case 2:
                                task.setStatus("Unfinished");
                                break;
                            default:
                                System.out.println("Choose another option!");
                        }
                    default:
                        System.out.println("Input error, please try again!");
                }
            }
        }
    }



    @Override
    public List<Task> getAll() {

        return myTask;
    }


}

