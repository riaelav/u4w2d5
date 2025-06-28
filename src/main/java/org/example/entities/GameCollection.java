package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class GameCollection {

    List<Collection> games = new ArrayList<>();

    public boolean add(Collection newGame) {
        for (Collection game : games) {
            if (game.getId().equals(newGame.getId())) {
                System.out.println("ID already exists: " + newGame.getId());
                return false;
            }
        }
        games.add(newGame);
        System.out.println("Game added: " + newGame.getTitle());
        return true;
    }

    public List<Collection> getGames() {
        return games;
    }


}
