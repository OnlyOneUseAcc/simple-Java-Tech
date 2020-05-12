package ru.billing.stocklist;

import java.util.Objects;

/**
 * Technical item class
 */
public class TechnicalItem extends GenericItem {
    /**
     * field of warranty time
     */
    private short warrantyTime;

    /**
     * Constructor with all fields except analog
     * @param name name
     * @param price price
     * @param type enum type of item
     * @param warrantyTime time of warranty
     */
    public TechnicalItem(String name, float price, Category type, short warrantyTime) {
        super(name, price, type);
        this.warrantyTime = warrantyTime;
    }

    /**
     * private constructor for clone
     * @param id ID of item
     * @param name name
     * @param price price
     * @param type enum type of item
     * @param warrantyTime time of warranty
     */
    private TechnicalItem(int id, String name, float price, Category type, short warrantyTime) {
        super(id, name, price, type);
        this.warrantyTime = warrantyTime;
    }

    /**
     * print all information about item
     */
    @Override
    public void printAll() {
        super.printAll();
        System.out.println("\tTime of warranty: " + warrantyTime);
    }

    /**
     * standard equals method
     * @param o any object
     * @return compare of two objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TechnicalItem)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    /**
     * Hash code of item
     * @return item hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyTime);
    }

    /**
     * convert item to string
     * @return values of fields
     */
    @Override
    public String toString() {
        return "TechnicalItem{" +
                "warrantyTime=" + warrantyTime +
                " include: " + super.toString() +
                '}';
    }

    /**
     * Clone item
     * @return same object
     */
    public Object clone() {
        TechnicalItem out = new TechnicalItem(
                super.getId(),
                super.getName(),
                super.getPrice(),
                super.getType(),
                this.warrantyTime);
        out.setAnalog(new GenericItem(getAnalog().getId(), getAnalog().getName(),
                 getAnalog().getPrice(), getAnalog().getType()));

        return out;
    }
}
