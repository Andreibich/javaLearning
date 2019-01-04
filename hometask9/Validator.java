package com.htp.lesson9.hometask9;

import com.htp.lesson9.hometask9.exceptions.AgeException;
import com.htp.lesson9.hometask9.exceptions.EducationException;
import com.htp.lesson9.hometask9.exceptions.NameException;
import com.htp.lesson9.hometask9.exceptions.SexException;
import com.htp.lesson9.hometask9.exceptions.SurNameException;

public class Validator {


    //        1. Name check
    public static void method(User user) /*throws NameException, SurNameException, AgeException, SexException,
            EducationException*/ {
        boolean nameValid = true;
        boolean surnameValid = true;
        boolean ageValid = true;
        boolean sexValid = true;
        boolean educationValid = true;

        try {
            int a1 = 0;

            for (int i1 = 0; i1 < user.getName().toCharArray().length; i1++) {
                if (Character.isLetter(user.getName().toCharArray()[i1])) {
                    a1 += 0;
                } else {
                    a1 += 1;
                }
            }
            if (user.getName().length() > 20 || a1 > 0 || user.getName() == null) {
                throw new NameException("Incorrect field \"Name\"");
            }
        } catch (NameException e) {
            System.out.println(e.getCustomMessage());
            nameValid = false;
        }


        //        2. Surname check

        try {
            int a2 = 0;
            for (int i1 = 0; i1 < user.getSurname().toCharArray().length; i1++) {
                if (Character.isLetter(user.getSurname().toCharArray()[i1])) {
                    a2 += 0;
                } else {
                    a2 += 1;
                }
            }
            if (user.getSurname().length() > 20 || a2 > 0 || user.getName() == null) {
                throw new SurNameException("Incorrect field \"Surame\"");
            }
        } catch (SurNameException e) {
            System.out.println(e.getCustomMessage());
            surnameValid = false;
        }


        //         3. Age check

        try {
            if (user.getAge() < 18 || user.getAge() > 90) {
                throw new AgeException("Incorrect field \"Age\"");
            }
        } catch (AgeException e) {
            System.out.println(e.getCustomMessage());
            ageValid = false;
        }

        //        4. Sex check

        try {
            if (user.getSex().equals("male") || user.getSex().equals("female")) {
            } else {
                throw new SexException("Incorrect field \"Sex\"");
            }
        } catch (SexException e) {
            System.out.println(e.getCustomMessage());
            sexValid = false;
        }


        //        5. Education check

        try{
        if (user.getEducation().equals("higher") || user.getEducation().equals("special") ||
                user.getEducation().equals("secondary")) {
        } else {
            throw new EducationException("Incorrect field \"Education\"");
        }}
        catch (EducationException e){
            System.out.println(e.getCustomMessage());
            educationValid = false;
        }



        System.out.println("\nnameValid = " + nameValid);
        System.out.println("surnameValid = " + surnameValid);
        System.out.println("ageValid = " + ageValid);
        System.out.println("sexValid = " + sexValid);
        System.out.println("educationValid = " + educationValid);
    }


}





