package org.example;

public class BdayFormatException extends NumberFormatException {

    BdayFormatException(){
        super("The format of BirthDay is not correct.");
    }

}
