package org.example;

public class GenderException extends Exception{

    GenderException (){
        super("Gender can be only 'm' or 'f'");
    }

}
