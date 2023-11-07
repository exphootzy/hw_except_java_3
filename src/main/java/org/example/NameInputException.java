package org.example;

public class NameInputException extends NumberFormatException{

    NameInputException () {
        super("Name supposed to include only symbols.");
    }

}
