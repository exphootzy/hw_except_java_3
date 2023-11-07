package org.example;

public class NotEnoughData extends Exception{

    NotEnoughData () {
        super("You haven't input enough information.");
    }

}
