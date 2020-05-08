package ru.billing.stocklist;

import java.util.Objects;

public class GenericItem {
    private int ID;
    private String name;
    private float price;
    private GenericItem analog;
    private Category type = Category.GENERAL;
    private static int currentID;

    public GenericItem() {
        GenericItem.currentID++;
        this.ID = currentID;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        GenericItem.currentID++;
        this.ID = currentID;
        this.name = name;
        this.price = price;
        this.analog = analog;
    }

    public GenericItem(String name, float price, Category type) {
        GenericItem.currentID++;
        this.ID = currentID;
        this.name = name;
        this.price = price;
        if (type == null){
            type = Category.GENERAL;
        }
        this.type = type;
    }

    protected GenericItem(int ID, String name, float price, Category type) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public void printAll() {
        System.out.println("ID: " + ID + ", Name: " + name +
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
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogs=" + defAnalog +
                ", type=" + type +
                '}';
    }

    public int getID() {
        return ID;
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
                analog.ID,
                analog.name,
                analog.price,
                analog.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericItem)) return false;
        GenericItem item = (GenericItem) o;
        return ID == item.ID &&
                Float.compare(item.price, price) == 0 &&
                name.equals(item.name) &&
                Objects.equals(analog, item.analog) &&
                type == item.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price, analog, type);
    }
}

