package ru.billing.stocklist;

import java.util.Date;
import java.util.Objects;

/**
 * Class Food item
 * contains date od income and expires
 * extends GenericItem
 */
public class FoodItem extends GenericItem {
    /**
     * item date of income
     */
    private Date dateOfIncome;
    /**
     * how long item available
     */
    private short expires;

    /**
     * Constructor which include all fields of class
     * @param name name
     * @param price price
     * @param type enum type of item
     * @param dateOfIncome date of income
     * @param expires how long item available
     */
    public FoodItem(String name, float price, Category type, Date dateOfIncome, short expires) {
        super(name, price, type);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    /**
     * Constructor which include all fields of class except dateOfIncome
     * call first constructor with default value
     * @param name name
     * @param price price
     * @param type enum type of item
     * @param expires how long item available
     */
    public FoodItem(String name, float price, Category type,  short expires) {
        this(name, price, type, new Date(), expires);
    }

    /**
     * Constructor with only name of item
     * call first constructor with default values
     * @param name name
     */
    public FoodItem(String name) {
        this(name, (float) 0, Category.GENERAL, new Date(), (short) 0);
    }

    /**
     * private constructor for clone
     * @param name name
     * @param price price
     * @param type enum type of item
     * @param dateOfIncome date of income
     * @param expires how long item available
     */
    private FoodItem(int id, String name, float price, Category type, Date dateOfIncome, short expires) {
        super(id, name, price, type);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    /**
     * print all information about item
     */
    @Override
    public void printAll() {
        super.printAll();
        if (dateOfIncome != null) {
            System.out.println("\tIncome date: " + dateOfIncome.toString() + " expires: " + expires);
        }
    }

    /**
     * method equals
     * @param o any object
     * @return compare of two objects
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FoodItem)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                dateOfIncome.equals(foodItem.dateOfIncome);
    }

    /**
     * Get hash of item
     * @return hash of item
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfIncome, expires);
    }

    /**
     * convert item to string
     * @return values of fields
     */
    @Override
    public String toString() {
        return "FoodItem{" +
                "dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                "include: " + super.toString() +
                '}';
    }

    /**
     * clone of this item
     * @return clone of item
     */
    public Object clone() {
        FoodItem out = new FoodItem(
                super.getId(),
                super.getName(),
                super.getPrice(),
                super.getType(),
                this.dateOfIncome,
                this.expires
        );
        out.setAnalog(new GenericItem(getAnalog().getId(), getAnalog().getName(),
                getAnalog().getPrice(), getAnalog().getType()));
        return out;
    }
}
