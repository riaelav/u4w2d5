package org.example.exceptions;

public class InvalidPlayerNumberException extends RuntimeException {
    public InvalidPlayerNumberException(int players) {
        super("Number not valid, must be between 2 and 10");
    }
}
