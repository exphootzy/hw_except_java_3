package org.example;

public class NotExistingData extends NullPointerException {

    NotExistingData() {
        super("You haven't entered any data.");
    }

}
