package org.example;

import org.example.entities.Boardgames;
import org.example.entities.Collection;
import org.example.entities.Videogames;
import org.example.enums.Genre;
import org.example.exceptions.GameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {


    static List<Collection> games = new ArrayList<>();

    public static void main(String[] args) {

        //aggiungo giochi
        addGame(new Videogames("VG001", "Skyrim", 2015, 29.99, "Xbox", 100, Genre.ADVENTURE));
        addGame(new Videogames("VG002", "Last of Us", 2024, 59.99, "PS5", 50, Genre.HORROR));
        addGame(new Boardgames("BG001", "Risiko", 1995, 35.0, 6, 180));
        addGame(new Boardgames("BG002", "Uno", 1980, 12.5, 5, 30));

        //ricerco giochi

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a game ID to search: ");
        String input = scanner.nextLine();

        try {
            Collection foundGame = searchById(input);
            System.out.println("Game found: " + foundGame.getTitle());
        } catch (GameNotFoundException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    // metodo per aggiungere un gioco evitando ID uguali
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

    //metofo ricerca per id
    public static Collection searchById(String id) {
        for (Collection game : games) {
            if (game.getId().equalsIgnoreCase(id)) {
                return game;

            }
        }

        throw new GameNotFoundException(id);

    }
}
