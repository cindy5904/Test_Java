package org.example;

import java.util.Objects;

public class Product {
    private String type;
    private String name;
    private int sellIn;
    private int quality;

    public Product(String type, String name, int sellIn, int quality) {
        this.type = type;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return sellIn == product.sellIn && quality == product.quality && Objects.equals(type, product.type) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, sellIn, quality);
    }

    public Product() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
