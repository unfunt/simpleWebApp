package com.fakecinema.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vova on 08.04.2019.
 */
public interface CrudDao<T> {

    // Get all items
    List<T> getAll() throws SQLException;

    // Get item By id
    T getById (int id) throws SQLException;

    // Create new item
    boolean create(T item) throws SQLException;

    // Update item
    boolean update (int id, T item) throws SQLException;

    // Delete item
    boolean delete (int id) throws SQLException;
}