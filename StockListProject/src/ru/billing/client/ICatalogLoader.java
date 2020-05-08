package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.stocklist.ItemCatalog;

/**
 * Interface for loading items catalog
 */
public interface ICatalogLoader {
    /**
     * load items in catalog
     * @param cat catalog for loading
     * @throws CatalogLoadException any mistake during work
     */
    public void load (ItemCatalog cat) throws CatalogLoadException;
}
