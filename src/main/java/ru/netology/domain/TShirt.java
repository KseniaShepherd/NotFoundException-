package ru.netology.domain;

import java.util.Objects;

public class TShirt extends Product {
    private String color;
    private String size;

    public TShirt(int id, String name, String color, String size, int price) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt shirt = (TShirt) o;
        return Objects.equals(color, shirt.color) &&
                Objects.equals(size, shirt.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, size);
    }
}