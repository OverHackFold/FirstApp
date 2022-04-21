package project.app.menu;

import project.app.dao.ListRepositoryCollectionImpl;
import project.app.model.ListModel;

import java.util.List;
import java.util.Scanner;


public class Menu {
    Scanner scanner = new Scanner(System.in);
    ListRepositoryCollectionImpl listRepositoryCollection = new ListRepositoryCollectionImpl();

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


    public ListModel fillListData() {
        ListModel listModel = new ListModel();
        System.out.println("Enter task id:");
        listModel.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the name of the task:");
        listModel.setName(scanner.nextLine());
        System.out.println("Press space bar to continue");
        scanner.nextLine();
        System.out.println("Enter a task:");
        listModel.setTask(scanner.nextLine());

        listRepositoryCollection.save(listModel);
        return listModel;

    }

    public void viveLists() {
        List<ListModel> listModel = listRepositoryCollection.getAll();
        for (ListModel list : listModel) {
            System.out.println(list);
        }


    }

    public void deleteList() {
        viveLists();
        listRepositoryCollection.deleteByID();
    }

    public void chooseList() {
        viveLists();
        listRepositoryCollection.getByName();

    }
    public void listStatus(){
        viveLists();
        listRepositoryCollection.listSE();
    }


}
