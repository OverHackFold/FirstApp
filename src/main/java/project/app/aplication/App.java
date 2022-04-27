package project.app.aplication;

import project.app.dao.impl.TaskRepositoryJDBCImpl;
import project.app.menu.Menu;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu(new TaskRepositoryJDBCImpl());
        menu.viewMenu();
    }
}
