package org.example;

import org.example.entities.Boardgames;
import org.example.entities.Collection;
import org.example.entities.Videogames;
import org.example.enums.Genre;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Collection> games = new ArrayList<>();

        games.add(new Videogames("VG001", "Skyrim", 2015, 29.99, "Xbox", 100, Genre.ADVENTURE));
        games.add(new Videogames("VG002", "Last of Us", 2024, 59.99, "PS5", 50, Genre.HORROR));
        games.add(new Boardgames("BG001", "Risiko", 1995, 35.0, 6, 180));
        games.add(new Boardgames("BG002", "Uno", 1980, 12.5, 5, 30));
    }


}
