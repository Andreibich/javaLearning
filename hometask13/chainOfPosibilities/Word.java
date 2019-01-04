package com.htp.hometask13.chainOfPosibilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Word extends Text {
    public Word(int choise) {
        super(choise);
    }

    @Override
    public void write(String report) {
        try (FileReader fileReader = new FileReader("src/com/htp/hometask13/chainOfPosibilities/Text.txt");
             BufferedReader br = new BufferedReader(fileReader)) {
            int quantity = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArray = new String(line).trim().split("\\W");
                quantity += lineArray.length;
            }
            System.out.println("Quantity of words - " + quantity + " " + report);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }
}

