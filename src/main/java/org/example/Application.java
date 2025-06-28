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

        // ricerco i prezzi

        System.out.print("Enter max price: ");
        double maxPrice = scanner.nextDouble();

        List<Collection> filteredGames = searchByPrice(maxPrice);

        if (filteredGames.isEmpty()) {
            System.out.println("No games found under €" + maxPrice);
        } else {
            System.out.println("Games under €" + maxPrice + ":");
            for (Collection g : filteredGames) {
                System.out.println(g.getTitle() + g.getPrice());
            }
        }
//cerco gioco in base al numero di giocatori
        System.out.print("Enter number of players: ");
        String inputPlayers = scanner.nextLine();

        int playersToSearch;

        try {
            playersToSearch = Integer.parseInt(inputPlayers);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");

        }
        /*System.out.print("Enter the number of players: ");
        int playersToSearch = scanner.nextLine();

        List<Boardgames> results = searchByPlayers(playersToSearch);

        if (results.isEmpty()) {
            System.out.println("No games found for " + playersToSearch + " players.");
        } else {
            System.out.println(" Games for " + playersToSearch + " players:");
            for (Boardgames boardgame : results) {
                System.out.println(boardgame.getTitle());
            }
        }*/


        //elimino per id
        System.out.print("Enter the ID of the game to remove: ");
        String idToRemove = scanner.nextLine();

        removeById(idToRemove);


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

    //metodo ricerca per id
    public static Collection searchById(String id) {
        for (Collection game : games) {
            if (game.getId().equalsIgnoreCase(id)) {
                return game;

            }
        }

        throw new GameNotFoundException(id);

    }

    //metodo ricerca per prezzo (lista di prezzi inferiori all'input che verrà inserito)
    public static List<Collection> searchByPrice(double maxPrice) {
        return games.stream()
                .filter(game -> game.getPrice() < maxPrice)
                .toList();
    }

    // metodo di ricerca per numero di giocatori
    /*public static List<Collection> searchByPlayers(int player) {
        return games.stream()
                .filter(game -> game.getPlayers() == player)
    }*/
    public static List<Boardgames> searchByPlayers(int playerCount) {
        return games.stream()
                .filter(game -> game instanceof Boardgames)
                .map(game -> (Boardgames) game)
                .filter(boardgame -> boardgame.getPlayers() == playerCount)
                .toList();
    }
//metodo per rimuovere un gioco dalla lista tramite id

    public static void removeById(String id) {
        for (Collection game : games) {
            if (game.getId().equals(id)) {
                games.remove(game);
                return;
            }
        }
    }
}
