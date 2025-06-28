package org.example.entities;


import org.example.exceptions.InvalidPlayerNumberException;

public class Boardgames extends Collection {
    private int players;
    private int duration;

    public Boardgames(String id, String title, int year, double price, int players, int duration) {
        super(id, title, year, price);

        if (players < 2 || players > 10) {
            throw new InvalidPlayerNumberException(players);
        }

        this.players = players;
        this.duration = duration;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}