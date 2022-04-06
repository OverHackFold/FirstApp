package project.app.dao;

import project.app.model.ListModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMethods {

    private final ArrayList<ListModel> myLists = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void save(ListModel list) {
        myLists.add(list);
    }


    public void deleteById() {
        System.out.println("Введите ID элемента который хотите удалить");
        for (ListModel list : myLists) {
            System.out.println(list);
            myLists.removeIf(listModel -> {
                scanner.nextLine();
                return false;
            });
        }
    }

    public void getByName() {
        getAll();
        System.out.println("Введиет название элемента ");
        for (ListModel list : myLists) {
            if (scanner.nextLine().equals(list.getName())) {
                System.out.println(list);
            }
        }
    }

    public List<ListModel> getAll() {
        return myLists;
    }


}

