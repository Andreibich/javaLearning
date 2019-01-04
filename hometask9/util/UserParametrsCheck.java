package com.htp.lesson9.hometask9.util;

import com.htp.lesson9.hometask9.domain.User;
import com.htp.lesson9.hometask9.domain.exceptions.AgeException;
import com.htp.lesson9.hometask9.domain.exceptions.EducationException;
import com.htp.lesson9.hometask9.domain.exceptions.NameException;
import com.htp.lesson9.hometask9.domain.exceptions.SexException;
import com.htp.lesson9.hometask9.domain.exceptions.SurNameException;

public class UserParametrsCheck {

    public static void nameCheck(User user) throws NameException {
        int counter = 0;
        for (int i = 0; i < user.getName().toCharArray().length; i++) {
            if (Character.isLetter(user.getName().toCharArray()[i])) {
                counter += 0;
            } else {
                counter += 1;
            }
        }
        if (user.getName().length() > 20 || counter > 0 || user.getName() == null) {
            throw new NameException("Incorrect field \"Name\"");
        }
    }

    public static void surnameCheck(User user) throws SurNameException {
        int counter = 0;
        for (int i = 0; i < user.getSurname().toCharArray().length; i++) {
            if (Character.isLetter(user.getSurname().toCharArray()[i])) {
                counter += 0;
            } else {
                counter += 1;
            }
        }
        if (user.getSurname().length() > 20 || counter > 0 || user.getName() == null) {
            throw new SurNameException("Incorrect field \"Surame\"");
        }
    }

    public static void ageCheck(User user) throws AgeException {
        if (user.getAge() < 18 || user.getAge() > 90) {
            throw new AgeException("Incorrect field \"Age\"");
        }
    }

    public static void sexCheck(User user) throws SexException {
        if (user.getSex().equals("male") || user.getSex().equals("female")) {
        } else {
            throw new SexException("Incorrect field \"Sex\"");
        }
    }

    public static void educationCheck(User user) throws EducationException {
        if (user.getEducation().equals("higher") || user.getEducation().equals("special") ||
                user.getEducation().equals("secondary")) {
        } else {
            throw new EducationException("Incorrect field \"Education\"");
        }
    }
}
