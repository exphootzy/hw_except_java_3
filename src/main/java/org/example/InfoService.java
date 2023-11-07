package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
public class InfoService {

    public String getInfo() throws IOException, NotEnoughData, NameInputException, GenderException, BdayFormatException, NotExistingData, PhoneNumberException {
        System.out.println("Input your your last name, first name, surname, birthday, not split mobile phone number(only digits) and gender(m/f) with gaps:");
        try (Scanner cs = new Scanner(System.in)) {
            String personData = cs.nextLine();
            String[] personDataList = personData.split(" ");
            if (personDataList.length < 6) throw new NotEnoughData();
            if (!onlySymbols(personDataList)) throw new NameInputException();
            if (!checkBdayFormat(personDataList[3])) throw new BdayFormatException();
            if (personDataList[4].length() != 11 || !isDigit(personDataList[4])) throw new PhoneNumberException();
            if (personDataList[5].length() != 1 || (!personDataList[5].contains("m") && !personDataList[5].contains("f"))) throw new GenderException();

            return personData;
        }
    }

    public boolean onlySymbols(String[] data) {

        for (int i = 0; i < 3; i++) {
            if (!Pattern.matches("[a-zA-Z]+", data[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean checkBdayFormat(String str) {
        String[] strArr = str.split("\\.");
        return checkDigitsInBirthDay(str)
                && checkPointinBirthDay(str)
                && strArr[0].length() == 2
                && Integer.parseInt(strArr[0]) < 32
                && Integer.parseInt(strArr[0]) > 0
                && strArr[1].length() == 2
                && Integer.parseInt(strArr[1]) < 13
                && Integer.parseInt(strArr[1]) > 0
                && strArr[2].length() == 4
                && Integer.parseInt(strArr[2]) < 2020
                && Integer.parseInt(strArr[2]) > 1900;
    }

    public boolean checkPointinBirthDay(String str){
        return Character.toString(str.charAt(2)).equals(".") || Character.toString(str.charAt(5)).equals(".");
    }
    public boolean checkDigitsInBirthDay(String str) {
        String[] strArr = str.split("\\.");
        boolean flag = true;
        for (String s : strArr) if (!isDigit(s)) flag = false;
        return flag;
    }

    public static boolean isDigit(String str) {
        try {
            Long.parseLong(str);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

}
