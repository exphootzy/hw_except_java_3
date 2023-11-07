package org.example;

import java.io.IOException;
public class Program {

    public static void main(String[] args) throws NotEnoughData, GenderException {
        InfoService infoService = new InfoService();
        SaveService writeServise = new SaveService();
        try {
            String personInfo = infoService.getInfo();
            System.out.println(personInfo);
            writeServise.saveData(personInfo);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
