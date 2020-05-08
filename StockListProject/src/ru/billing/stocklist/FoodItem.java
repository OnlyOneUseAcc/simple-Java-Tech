package ru.billing.stocklist;

import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem {
    private Date dateOfIncome;
    private short expires;

    public FoodItem(String name, float price, Category type, Date dateOfIncome, short expires) {
        super(name, price, type);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    public FoodItem(String name, float price, Category type,  short expires) {
        new FoodItem(name, price, type, new Date(), expires);
    }

    public FoodItem(String name) {
        new FoodItem(name, (float) 0, Category.GENERAL, new Date(), (short) 0);
    }

    private FoodItem(int id, String name, float price, Category type, Date dateOfIncome, short expires) {
        super(id, name, price, type);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    @Override
    public void printAll() {
        super.printAll();
        if (dateOfIncome != null) {
            System.out.println("\tIncome date: " + dateOfIncome.toString() + " expires: " + expires);
        }
    }


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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateOfIncome, expires);
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                "include: " + super.toString() +
                '}';
    }

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
