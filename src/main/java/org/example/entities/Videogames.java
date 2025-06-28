package org.example.entities;

import org.example.enums.Genre;

public class Videogames extends Collection {

    //attributi solo di videogame
    private String platform;
    private int hours;
    private Genre genre;

    //costruttore
    public Videogames(String id, String title, int year, double price, String platform,
                      int hours, Genre genre) {
        super(id, title, year, price);
        this.platform = platform;
        this.hours = hours;
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}