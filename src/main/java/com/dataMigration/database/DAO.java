package com.dataMigration.database;

import java.util.List;

public interface DAO<T> {

    void deleteById(int id);

    void updated(T update);

    int insert(T newRow);

    T findById(int id);

    List<T> findAll();

}
