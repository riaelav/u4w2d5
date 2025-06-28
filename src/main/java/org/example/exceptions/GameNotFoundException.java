package org.example.exceptions;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String id) {
        super("Game with ID '" + id + "' not found.");
    }
}
