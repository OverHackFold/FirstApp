package project.app;


import project.app.dao.ListMethods;
import project.app.model.ListModel;

import java.util.Scanner;
import java.util.List;


public class Menu {
    Scanner scanner = new Scanner(System.in);
    ListMethods listMethods = new ListMethods();

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void viewMenu() {
        boolean active = true;
        while (active) {
            System.out.printf("\n1.Вывести список\n2.Добавить задачу \n3.Удалить задачу\n4.Выбрать задачу для редактирования\n5.Выход");
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
                    active = false;
                    break;
                default:
                    System.out.println("Chose another variant");
            }
        }

    }


    public ListModel fillListData() {
        ListModel listModel = new ListModel();
        listModel.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Введите Наименование задачи:");
        listModel.setName(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Введите задачу:");
        listModel.setTask(scanner.nextLine());

        listMethods.save(listModel);
        return listModel;

    }

    public void viveLists() {
        List<ListModel> listModel = listMethods.getAll();
        for (ListModel list : listModel) {
            System.out.println(list);
        }


    }

    public void deleteList() {
        listMethods.deleteById();
    }

    public void chooseList() {
        viveLists();
        System.out.println("Введите название задачи которую хотите отредактировать:");
        listMethods.getByName();


    }

}
