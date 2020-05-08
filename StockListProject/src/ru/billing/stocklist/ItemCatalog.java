package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {

    private HashMap<Integer,GenericItem> catalog =
            new HashMap<Integer,GenericItem>();
    private ArrayList<GenericItem> allCatalog =
            new ArrayList<GenericItem>();

    public ItemCatalog(){
        this.catalog = new HashMap<>();
        this.allCatalog = new ArrayList<>();
    }

    public void addItem(GenericItem item) throws ItemAlreadyExistException {
        if (catalog.containsKey(item.getID()))
            throw new ItemAlreadyExistException();
        catalog.put(item.getID(), item);
        allCatalog.add(item);
    }

    public void printItems(){
        for (GenericItem tempItem : allCatalog){
            System.out.println(tempItem.toString());
        }
    }

    public GenericItem findItemByID(int id){
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id){
        for(GenericItem i : allCatalog){
            if(i.getID() == id)
                return i;
        }
        return null;
    }




}
