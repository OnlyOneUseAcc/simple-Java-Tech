package ru.billing.stocklist;

import java.util.Objects;

public class TechnicalItem extends GenericItem {

    private short warrantyTime;

    public TechnicalItem( String name, float price, Category type, short warrantyTime) {
        super( name, price, type);
        this.warrantyTime = warrantyTime;
    }

    private TechnicalItem(int ID, String name, float price, Category type, short warrantyTime) {
        super(ID, name, price, type);
        this.warrantyTime = warrantyTime;
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.println("\tTime of warranty: " + warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechnicalItem)) return false;
        if (!super.equals(o)) return false;
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyTime);
    }

    @Override
    public String toString() {
        return "TechnicalItem{" +
                "warrantyTime=" + warrantyTime +
                " include: " + super.toString() +
                '}';
    }

    public Object clone(){
         TechnicalItem out = new TechnicalItem(
                super.getID(),
                super.getName(),
                super.getPrice(),
                super.getType(),
                this.warrantyTime);
         out.setAnalog(new GenericItem(getAnalog().getID(), getAnalog().getName(),
                 getAnalog().getPrice(), getAnalog().getType()));

        return out;
    }
}
