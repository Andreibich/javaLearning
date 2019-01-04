package com.htp.hometask13.chainOfPosibilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sentence extends Text {
    public Sentence(int choise) {
        super(choise);
    }

    @Override
    public void write(String report) {
        try (FileReader fileReader = new FileReader("src/com/htp/hometask13/chainOfPosibilities/Text.txt");
             BufferedReader br = new BufferedReader(fileReader)) {
            int quantity;
            String line;
            StringBuilder lineSB = new StringBuilder();
            while ((line = br.readLine()) != null) {
                lineSB.append(line);
            }
            String text = lineSB.toString();
            String[] sentenceArray = new String(text).trim().split("[.!?]+");
            quantity = sentenceArray.length;
            System.out.println("Quantity of sentences - " + quantity + " " + report);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }
}
