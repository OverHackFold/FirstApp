package project.app.menu;

import project.app.dao.TaskRepositoryCollectionImpl;
import project.app.model.Task;

import java.util.List;
import java.util.Scanner;


public class Menu {
    Scanner scanner = new Scanner(System.in);
    TaskRepositoryCollectionImpl listRepositoryCollection = new TaskRepositoryCollectionImpl();

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void viewMenu() {
        boolean active = true;
        while (active) {
            System.out.println("\n1.View tasks\n2.Add task \n3.Delete task\n4.Choice task to edit\n5.Task status\n6.Exit");
            switch (getUserChoice()) {
                case 1:
                    viveLists();
                    break;
                case 2:
                    fillListData();
                    break;
                case 3:
                    deleteList();
                    break;
                case 4:
                    chooseList();
                    break;
                case 5:
                    listStatus();
                    break;
                case 6: active = false;
                    break;
                default:
                    System.out.println("Choice another variant!");
            }
        }

    }

    // todo fill, если ты заполняешь таск, вроде fillTask(Task task)
    //  А у тебя createTask()
    public Task fillListData() {
        Task task = new Task();
        System.out.println("Enter task id:");
        task.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the name of the task:");
        task.setName(scanner.nextLine());
        System.out.println("Press space bar to continue");
        scanner.nextLine();
        System.out.println("Enter a task:");
        task.setTask(scanner.nextLine());

        listRepositoryCollection.save(task);
        return task;

    }

    // todo Может все таки view? В идеале show. И ты показываешь один list!?
    //  Значит showList. Но это если он обобщенный. Если ты показываешь таски,
    //  то showTasks()
    public void viveLists() {
        List<Task> task = listRepositoryCollection.getAll();
        for (Task list : task) {
            System.out.println(list);
        }
    }

    public void deleteList() {
        // todo Зачем?
        viveLists();
        listRepositoryCollection.deleteByID();
    }

    // todo опять же chooseTask
    public void chooseList() {
        // todo Зачем?
        viveLists();
        listRepositoryCollection.getByName();

    }

    // todo editStatus()
    public void listStatus(){
        // todo Зачем?
        viveLists();
        listRepositoryCollection.listSE();
    }


}
