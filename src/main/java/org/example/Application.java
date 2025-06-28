package org.example;

import org.example.entities.Boardgames;
import org.example.entities.Collection;
import org.example.entities.Videogames;
import org.example.enums.Genre;

import java.util.ArrayList;
import java.util.List;

public class Application {


    static List<Collection> games = new ArrayList<>();

    public static void main(String[] args) {


        addGame(new Videogames("VG001", "Skyrim", 2015, 29.99, "Xbox", 100, Genre.ADVENTURE));
        addGame(new Videogames("VG002", "Last of Us", 2024, 59.99, "PS5", 50, Genre.HORROR));
        addGame(new Boardgames("BG001", "Risiko", 1995, 35.0, 6, 180));
        addGame(new Boardgames("BG002", "Uno", 1980, 12.5, 5, 30));

    }

    // metodo per aggiungere un gioco evitando
    public static void addGame(Collection game) {
        for (Collection g : games) {
            if (g.getId().equals(game.getId())) {
                System.out.println("Game with ID '" + game.getId() + "' already exists.");
                return;
            }
        }
        games.add(game);
        System.out.println("Game added: " + game.getTitle());
    }

}
