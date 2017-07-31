package com.alexander.makarov.database;

import com.alexander.makarov.model.ListToMemorize;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ListsDaoImpl implements ListsDao {

    private Connection connection;

    private static final String INSERT_LIST_STATEMENT = "INSERT INTO USERSLISTS (USERNAME, LISTNAME) VALUES (?, ?)";

    public ListsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ListToMemorize> getUserLists(String userName) {
        return null;
    }

    @Override
    public List<String> getListItems(String listName) {
        return null;
    }

    @Override
    public void addList(String listName, String repetitionFrequency) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_LIST_STATEMENT);
        statement.setString(1, listName);
        statement.setString(2, repetitionFrequency);
    }

    @Override
    public void addItem(String listName, String itemName) {

    }

    @Override
    public void deleteList(String listName) {

    }

    @Override
    public void deleteItem(String listName, String itemName) {

    }
}
