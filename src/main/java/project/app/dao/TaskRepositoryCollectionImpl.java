package project.app.dao;

import project.app.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskRepositoryCollectionImpl implements TaskRepository {
    private final ArrayList<Task> myLists = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    // todo Task task или Task entity, чтобы сделать потом T entity
    public void save(Task list) {
        // todo добавь sout в конце метода. что операция прошла успешно.
        myLists.add(list);
    }

    @Override
    public void deleteByID() {
        System.out.println("Enter the ID of the task you want to delete:");
        Integer gUC = scanner.nextInt();
        //todo Task task: tasks, если ты его переделаешь потом в generic,
        // то T entity: entities
        // А зачем здесь вывод всех сущностей?
        for (Task list : myLists) {
            System.out.println(list);
        }
        myLists.removeIf(listModel -> gUC.equals(listModel.getId()));
        System.out.println("Task deleted successfully");
    }

    @Override
    // todo getByName если бы ты возвращал таск по имени, а так modify, change или edit.
    //
    public void getByName() {
        // todo Зачем getAll()? Он сейчас не делает ничего.
        getAll();
        System.out.println("Enter the name of the task:");
        Integer gUC1 =scanner.nextInt();
        for (Task list : myLists) {
            if (gUC1.equals(list.getId())) {
                System.out.println("Select the item you would like to edit:\n1.Change name\n2.Change the task");
                int gUC = scanner.nextInt();
                switch (gUC) {
                    case 1:
                        System.out.println("Enter a new name:");
                        list.setName(scanner.next());
                        System.out.println("Name successfully changed to: "+list.getName());
                        break;
                    case 2:
                        System.out.println("Enter a new task:");
                        list.setTask(scanner.next());
                        System.out.println("Task was successfully edited!");
                        break;
                    default:
                        System.out.println("Input error, please try again!");
                }
            }
        }
    }

    @Override
    // todo editStatus
    public void listSE() {
        // todo Зачем getAll()? Он сейчас не делает ничего.
        getAll();
        System.out.println("Choice a task to edit the status:");
        Integer gUC = scanner.nextInt();
        for(Task list : myLists){
            if(gUC.equals(list.getId())){
                System.out.println("To mark a task as completed, press 1;\nTo mark a task as NOT completed, press 2;");
                int gUc =scanner.nextInt();
                switch (gUc){
                    case 1:
                        list.setStatus("✔");
                        break;
                    case 2:
                        list.setStatus("✘");
                        break;
                    default:
                        System.out.println("Choose another option!");
                }


            }
        }
    }

    @Override
    public List<Task> getAll() {
        return myLists;
    }


}

