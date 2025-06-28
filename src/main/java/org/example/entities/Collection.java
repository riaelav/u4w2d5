package org.example.entities;

import org.example.exceptions.NumberLessThanZeroException;

public abstract class Collection {

    //attributi
    private final String id;
    private String title;
    private int year;
    private double price;

    //costruttore
    public Collection(String id, String title, int year, double price) {
        if (price < 0) {
            throw new NumberLessThanZeroException(price);
        }
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

