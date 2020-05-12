package ru.billing.client;


import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistException;
import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.TechnicalItem;
import ru.billing.stocklist.ItemCatalog;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        GenericItem first = new GenericItem("first", (float) 450.23, Category.DRESS);
        GenericItem second = new GenericItem("second", (float) 100, Category.DRESS);
        GenericItem third = new GenericItem("third", (float) 896.23, Category.FOOD);

        first.setAnalog(second);
        second.setAnalog(first);

        first.printAll();
        second.printAll();
        third.printAll();

        FoodItem foodItem1 = new FoodItem("new1", (float) 456, Category.FOOD, new Date(), (short) 10);
        TechnicalItem techItem2 = new TechnicalItem("new2", (float) 456, Category.FOOD, (short) 15);

        foodItem1.setAnalog(techItem2);
        techItem2.setAnalog(foodItem1);

        GenericItem[] allItems = new GenericItem[]{foodItem1, techItem2};
        for (GenericItem item : allItems) {
            item.printAll();
        }

        System.out.println(foodItem1.equals(techItem2));

        TechnicalItem techItem3 = (TechnicalItem) techItem2.clone();
        System.out.println(techItem2.equals(techItem3));


        GenericItem[] items = new GenericItem[]{
          new FoodItem("jank", (float) 1500, Category.FOOD, (short) 10),
          new GenericItem("car", (float) 263.23, Category.GENERAL),
          new FoodItem("kolocol"),
          techItem2, foodItem1,
          first, second, second
        };
        ItemCatalog catalog = new ItemCatalog();
        for (GenericItem item : items) {
            try {
                catalog.addItem(item);
            } catch (ItemAlreadyExistException e) {
                System.out.println("Catch");
            }
        }
        long begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            catalog.findItemByID(9);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));
        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            catalog.findItemByIDAL(9);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        CatalogStubLoader loader = new CatalogStubLoader();

        try {
            loader.load(catalog);
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }

        catalog.printItems();




    }
}
