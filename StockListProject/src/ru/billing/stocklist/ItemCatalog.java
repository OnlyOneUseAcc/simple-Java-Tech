package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Catalog of items
 */
public class ItemCatalog {
    /**
     * container of items1 (hashmap)
     */
    private HashMap<Integer, GenericItem> catalog =
            new HashMap<Integer, GenericItem>();

    /**
     * container of items1 (ArrayList)
     */
    private ArrayList<GenericItem> allCatalog =
            new ArrayList<GenericItem>();

    /**
     * Default constructor
     */
    public ItemCatalog() {
        this.catalog = new HashMap<>();
        this.allCatalog = new ArrayList<>();
    }

    /**
     * Adds item to both containers
     * @param item any generic item
     * @throws ItemAlreadyExistException if item already in containers
     */
    public void addItem(GenericItem item) throws ItemAlreadyExistException {
        if (catalog.containsKey(item.getId())) {
            throw new ItemAlreadyExistException();
        }
        catalog.put(item.getId(), item);
        allCatalog.add(item);
    }

    /**
     * print all items
     */
    public void printItems() {
        for (GenericItem tempItem : allCatalog) {
            System.out.println(tempItem.toString());
        }
    }

    /**
     * return item by ID (from hashMap)
     * @param id id of item
     * @return item with input ID or null
     */
    public GenericItem findItemByID(int id) {
        return catalog.getOrDefault(id, null);
    }

    /**
     * return item by ID (from List)
     * @param id id of item
     * @return item with input ID or null
     */
    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : allCatalog) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }




}
