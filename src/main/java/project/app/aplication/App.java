package project.app.aplication;

import project.app.dao.impl.TaskRepositoryCollectionImpl;
import project.app.menu.Menu;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu(new TaskRepositoryCollectionImpl());
        menu.viewMenu();
    }
}
