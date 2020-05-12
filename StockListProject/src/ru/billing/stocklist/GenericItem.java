package ru.billing.stocklist;

import java.util.Objects;

/**
 * any item of project
 */
public class GenericItem {
    /**
     * static field for get ID of new iem
     */
    private static int currentID;
    /**
     * ID if this item
     */
    private int id;
    /**
     * name of item
     */
    private String name;
    /**
     * price of item
     */
    private float price;
    /**
     * link to analog of this item
     */
    private GenericItem analog;
    /**
     * enum type of item
     */
    private Category type = Category.GENERAL;

    /**
     * default constructor
     */
    public GenericItem() {
        GenericItem.currentID++;
        this.id = currentID;
    }

    public GenericItem(String name, float price, GenericItem analog, Category type) {
        GenericItem.currentID++;
        this.id = currentID;
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.type = type;
    }

    /**
     * Constructor without category
     * @param name name of item
     * @param price price of item
     */
    public GenericItem(String name, float price, GenericItem analog) {
        this(name, price, analog, Category.GENERAL);
    }

    /**
     * Constructor without analog
     * @param name name of item
     * @param price price of item
     * @param type enum type of item
     */
    public GenericItem(String name, float price, Category type) {
        this(name, price, null, type);
    }

    /**
     * Constructor only for clone
     * @param id ID of new item
     * @param name name of item
     * @param price price of item
     * @param type enum type of item
     */
    protected GenericItem(int id, String name, float price, Category type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    /**
     * print all information about item
     */
    public void printAll() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", type: " + type.toString() + ", price: " + price);
        if (analog != null) {
            System.out.print("\tAnalog: " + analog.name + " ");

        }
        System.out.println();
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    /**
     * convert item to string
     * @return values of fields
     */
    @Override
    public String toString() {

        String defAnalog = analog == null ? "none" : analog.name;

        return "GenericItem{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogs=" + defAnalog +
                ", type=" + type +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public Category getType() {
        return type;
    }

    public Object clone() {
        if (this.analog == null) {
            return null;
        }
        return new GenericItem(
                analog.id,
                analog.name,
                analog.price,
                analog.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GenericItem)) {
            return false;
        }
        GenericItem item = (GenericItem) o;
        return id == item.id &&
                Float.compare(item.price, price) == 0 &&
                name.equals(item.name) &&
                Objects.equals(analog, item.analog) &&
                type == item.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, analog, type);
    }
}

