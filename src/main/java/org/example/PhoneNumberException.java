package org.example;

public class PhoneNumberException extends NumberFormatException {

    PhoneNumberException () {
        super("Phone number supposed to include 11 digits");
    }
}
