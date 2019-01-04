
package com.htp.hometask10.util;

import com.htp.hometask10.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LetterCheck {
    private static final char letter1 = 'А';
    private static final char letter2 = 'У';
    private static final char letter3 = 'Е';
    private static final char letter4 = 'О';
    private static final char letter5 = 'Э';
    private static final char letter6 = 'Я';
    private static final char letter7 = 'И';
    private static final char letter8 = 'Ю';

    public LetterCheck() {
    }

    public static char getLetter1() {
        return letter1;
    }

    public static char getLetter2() {
        return letter2;
    }

    public static char getLetter3() {
        return letter3;
    }

    public static char getLetter4() {
        return letter4;
    }

    public static char getLetter5() {
        return letter5;
    }

    public static char getLetter6() {
        return letter6;
    }

    public static char getLetter7() {
        return letter7;
    }

    public static char getLetter8() {
        return letter8;
    }


    public void checkMethod(Set<Book> set) {
        List<Character> letterCheckList = new ArrayList<>();
        letterCheckList.add(letter1);
        letterCheckList.add(letter2);
        letterCheckList.add(letter3);
        letterCheckList.add(letter4);
        letterCheckList.add(letter5);
        letterCheckList.add(letter6);
        letterCheckList.add(letter7);
        letterCheckList.add(letter8);

        for (Book element : set) {
            for (Character findLetter : letterCheckList) {
                char firstLetter = element.getTitle().charAt(0);
                if (findLetter.equals(firstLetter)) {
                    System.out.println(element);
                }
            }
        }
    }
}