package models;

import java.util.Objects;

/**
 * Class BaseModel
 */
public class BaseModel {
    protected int id;

    /**
     * Overrated equals method
     *
     * @param o Input object
     * @return Comparison result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseModel baseModel = (BaseModel) o;
        return id == baseModel.id;
    }

    /**
     * Overrated hashCode method
     *
     * @return Hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
