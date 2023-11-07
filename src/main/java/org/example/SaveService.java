package org.example;

import java.io.*;
public class SaveService {

    public void saveData (String data) {
        try (Writer writer = new FileWriter("personalData.txt")) {
            writer.write(data + "\n");
            System.out.println("Your data saved.");
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
