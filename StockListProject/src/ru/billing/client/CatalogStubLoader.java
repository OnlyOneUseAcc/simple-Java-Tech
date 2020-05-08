package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistException;
import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;

import java.util.Date;

/**
 * Class for load two items in catalog
 */
public class CatalogStubLoader implements ICatalogLoader {

    /**
     * load two items in catalog
     * @param cat catalog for loading
     * @throws CatalogLoadException throw in situation with ItemAlreadyExistException
     */
    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        GenericItem item1 = new GenericItem("Sony TV", 23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread", 12, null, new Date(), (short) 10);
        try {
            cat.addItem(item1);
            cat.addItem(item2);
        } catch (ItemAlreadyExistException e) {
            throw new CatalogLoadException();
        }
    }
}
