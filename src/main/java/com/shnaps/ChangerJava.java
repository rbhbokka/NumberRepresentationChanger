package com.shnaps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangerJava {
    private static DecimalNumbers changerJava;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/source.txt")));
            try {
                System.out.println("Starting reading from file:\n");
                String data = reader.readLine();
                while (data != null) {
                    System.out.println("Read date from file: " + data);
                    DecimalNumbers dataNumber = new DecimalNumbers(data);
                    String dataNumberInString = dataNumber.numberToString();
                    System.out.println("Date converted to string: " + dataNumberInString + "\n");
                    data = reader.readLine();
                }
            } finally {
                reader.close();
            }
            changerJava = new DecimalNumbers("547676557550000000");
            String numberInString = changerJava.numberToString();
            System.out.println("Readed number from program: " + changerJava.getNumber() + "\nRead by hand: " + numberInString);
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Wrong input\n" + ex.getMessage());
        }
    }
}


