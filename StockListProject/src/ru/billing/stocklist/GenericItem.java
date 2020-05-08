package ru.billing.stocklist;

import java.util.Objects;

public class GenericItem {
    private static int currentID;
    private int id;
    private String name;
    private float price;
    private GenericItem analog;
    private Category type = Category.GENERAL;


    public GenericItem() {
        GenericItem.currentID++;
        this.id = currentID;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        GenericItem.currentID++;
        this.id = currentID;
        this.name = name;
        this.price = price;
        this.analog = analog;
    }

    public GenericItem(String name, float price, Category type) {
        GenericItem.currentID++;
        this.id = currentID;
        this.name = name;
        this.price = price;
        if (type == null) {
            type = Category.GENERAL;
        }
        this.type = type;
    }

    protected GenericItem(int id, String name, float price, Category type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

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

