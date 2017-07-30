package com.alexander.makarov.database;

import com.alexander.makarov.model.ListToMemorize;

import java.util.List;

public interface ListsDao {

    List<ListToMemorize> getUserLists(String userName);

    List<String> getListItems(String listName);

    void addList(String listName, long repetitionFrequency);

    void addItem(String listName, String itemName);

    void deleteList(String listName);

    void deleteItem(String listName, String itemName);

}
