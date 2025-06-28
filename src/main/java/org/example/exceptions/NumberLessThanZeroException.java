package org.example.exceptions;

public class NumberLessThanZeroException extends RuntimeException {
    public NumberLessThanZeroException(int num) {
        super("Il numero inserito " + num + " è inferiore allo zero!");
    }

    public NumberLessThanZeroException(double num) {
        super("Number " + num + " not valid, is less than zero");
    }
}
