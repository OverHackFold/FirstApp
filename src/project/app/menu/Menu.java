package project.app.menu;

import project.app.ListRepositoryCollectionImpl;
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
            System.out.printf("\n1.Вывести список\n2.Добавить задачу \n3.Удалить задачу\n4.Выбрать задачу для редактирования\n5.Статус задачи\n6.Выход");
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
                    System.out.println("Выберите другой вариант!");
            }
        }

    }


    public ListModel fillListData() {
        ListModel listModel = new ListModel();
        System.out.println("Введите номер задачи:");
        listModel.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Введите Наименование задачи:");
        listModel.setName(scanner.nextLine());
        System.out.println("Нажмите пробел для того чтоб продолжить");
        scanner.nextLine();
        System.out.println("Введите задачу:");
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
