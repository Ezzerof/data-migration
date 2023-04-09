package com.dataMigration.database;

import java.util.List;
import java.util.Map;

public interface DAO<T> {

    void deleteById(int id);

    void updated(T update);

    int insert(T newEmployee);

    T findById(int id);

    Map<Integer, T> findAll();

}
