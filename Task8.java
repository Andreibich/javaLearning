package com.htp.lesson8;

import java.util.Random;

public class Task8 {
    private int numberOfLetters;

    public Task8() {
    }

    public Task8(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public void setNumberOfLetters(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task8 task8 = (Task8) o;

        return numberOfLetters == task8.numberOfLetters;
    }

    @Override
    public int hashCode() {
        return numberOfLetters;
    }

    @Override
    public String toString() {
        return "Task8{" +
                "numberOfLetters=" + numberOfLetters +
                '}';
    }

    public String generateRandomWords() {

        Random random = new Random();

        char[] letter = new char[numberOfLetters];
        for (int j = 0; j < numberOfLetters; j++) {
            letter[j] = (char) ('a' + random.nextInt(26));
        }
        return new String(letter);

    }

    public static void main(String[] args) {
        Task8 task8 = new Task8(100);
        String word = task8.generateRandomWords();
        System.out.println(word);
        System.out.println(word.lastIndexOf("xx"));
        System.out.println(word.replaceAll("xx", "QQ"));
        System.out.println(word.lastIndexOf("z"));
    }
}
