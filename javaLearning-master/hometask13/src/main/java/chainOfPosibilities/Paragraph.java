package chainOfPosibilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Paragraph extends Text {
    public Paragraph(int choise) {
        super(choise);
    }

    @Override
    public void write(String report) {
        try (FileReader fileReader = new FileReader("src/com/htp/src.main.java.hometask13/chainOfPosibilities/Text.txt");
             BufferedReader br = new BufferedReader(fileReader)) {
            int quantity;
            String line;
            StringBuilder lineSB = new StringBuilder();
            while ((line = br.readLine()) != null) {
                lineSB.append(line);
            }
            String text = lineSB.toString();
            String[] paragraphArray = new String(text).trim().split("\\t");
            quantity = paragraphArray.length;
            System.out.println("Quantity of paragraphs - " + quantity + " " + report);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }
}
