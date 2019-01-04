package com.htp.hometask13;

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Solution {

//    Task1

    static void task1Method(String file1, String file2) {
        try (FileReader fileReader = new FileReader("src/com/htp/hometask13/test/" + file1);
             BufferedReader br = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("src/com/htp/hometask13/test/" + file2);
             BufferedWriter bw = new BufferedWriter(fileWriter);
             PrintWriter pw = new PrintWriter(bw)) {
            String line;
            String changeLine;
            while ((line = br.readLine()) != null) {
                line = line.replace("JavaTest1", "JavaTest1Changed");
                changeLine = line.replace("public", "private");
                pw.write(changeLine + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести запись в файл: "
                    + file2);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }

    //    Task2

    static void task2Method(String file1, String file2) {
        try (FileWriter fileWriter1 = new FileWriter("src/com/htp/hometask13/test/" + file1);
             BufferedWriter bw1 = new BufferedWriter(fileWriter1);
             PrintWriter pw1 = new PrintWriter(bw1);
             FileReader fileReader = new FileReader("src/com/htp/hometask13/test/" + file1);
             BufferedReader br = new BufferedReader(fileReader);
             FileWriter fileWriter2 = new FileWriter("src/com/htp/hometask13/test/" + file2);
             BufferedWriter bw2 = new BufferedWriter(fileWriter2);
             PrintWriter pw2 = new PrintWriter(bw2)
        ) {

            Random random = new Random();
            for (int i = 0; i <= (10 + random.nextInt(10)); i++) {
                for (int j = 0; j <= random.nextInt(20); j++) {
                    pw1.write((random.nextInt(100)) + " ");
                }
                pw1.write("\n");
            }
            pw1.close();


            List<String> list = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArray = new String(line).trim().split("\\s+");
                List<String> tempList = Arrays.asList(lineArray);
                list.addAll(tempList);
            }


            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int result;
                    if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
                        result = 1;
                    } else if (Integer.parseInt(o1) < Integer.parseInt(o2)) {
                        result = -1;
                    } else {
                        result = 0;
                    }
                    return result;
                }
            });

            for (String element : list) {
                pw2.write(element + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести запись в файл: " + file2);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }

    //    Task 3

    static void task3Method(String file1, String file2) {
        try (FileReader fileReader = new FileReader("src/com/htp/hometask13/test/" + file1);
             BufferedReader br = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("src/com/htp/hometask13/test/" + file2);
             BufferedWriter bw = new BufferedWriter(fileWriter);
             PrintWriter pw = new PrintWriter(bw)) {
            String line;
            String firstWord;
            String lastWord;
            while ((line = br.readLine()) != null) {
                String[] lineArray = new String(line).trim().split("\\W");
                firstWord = lineArray[0];
                lastWord = lineArray[lineArray.length-1];
                lineArray[0] = lastWord;
                lineArray[lineArray.length-1] = firstWord;
                for (String element: lineArray){
                    pw.write(element + " ");
                }
                pw.write("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести запись в файл: "
                    + file2);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.toString());
        }
    }
}

