package project.app;

import project.app.model.ListModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListRepositoryCollectionImpl implements ListRepository {
    private final ArrayList<ListModel> myLists = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void save(ListModel list) {
        myLists.add(list);
    }

    @Override
    public void deleteByID() {
        int gUC = scanner.nextInt();
        System.out.println("Введите ID задачи:");
        for (ListModel list : myLists) {
            System.out.println(list);
        }
        myLists.removeIf(listModel -> gUC == (listModel.getId()));
        System.out.println("Задача успешно удалена");
    }

    @Override
    public void getByName() {
        getAll();
        System.out.println("Введиет название задачи:");
        int gUC1 =scanner.nextInt();
        for (ListModel list : myLists) {
            if (gUC1==(list.getId())) {
                System.out.println("Выберите пункт который бы хотели отредактировать:\n1.Изменить название\n2.Изменить задачу");
                int gUC = scanner.nextInt();
                switch (gUC) {
                    case 1:
                        System.out.println("Введите новое название:");
                        list.setName(scanner.next());
                        System.out.println("Название успешно изменено на: "+list.getName());
                        break;
                    case 2:
                        System.out.println("Введите новую задачу:");
                        list.setTask(scanner.next());
                        System.out.println("Задача усппешно отредактирована!");
                        break;
                    default:
                        System.out.println("Ошибка ввода , повторите попытку!");
                }
            }
        }
    }

    @Override
    public void listSE() {
        getAll();
        System.out.println("Выберите задачу чтобы отредактировать статус:");
        int gUC = scanner.nextInt();
        for(ListModel list : myLists){
            if(gUC==(list.getId())){
                System.out.println("Чтобы пометить задачу как выполненую ,нажмите 1;\nЧтобы пометить задачу как НЕвыполненную нажмите 2;");
                int gUc =scanner.nextInt();
                switch (gUc){
                    case 1:
                        list.setStatus("✔");
                        break;
                    case 2:
                        list.setStatus("✘");
                        break;
                    default:
                        System.out.println("Выберите другой вариант!");
                }


            }
        }
    }

    @Override
    public List<ListModel> getAll() {

        return myLists;
    }


}

