package project.app.dao;

import project.app.model.ListModel;

import java.util.List;

public interface ListRepository {

    void save(ListModel list);


    void deleteByID();

    void getByName();
    void listSE();

    List<ListModel> getAll();
}
