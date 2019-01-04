package com.htp.lesson9.hometask9.util;

import com.htp.lesson9.hometask9.domain.User;
import com.htp.lesson9.hometask9.domain.exceptions.AgeException;
import com.htp.lesson9.hometask9.domain.exceptions.EducationException;
import com.htp.lesson9.hometask9.domain.exceptions.NameException;
import com.htp.lesson9.hometask9.domain.exceptions.SexException;
import com.htp.lesson9.hometask9.domain.exceptions.SurNameException;

public class Validator {


    //TODO change name
    public static void checkUser(User user) {
        UserReport userReport = new UserReport();

        //        1. Name check
        try {
            //TODO method with naming
            UserParametrsCheck.nameCheck(user);
        } catch (NameException e) {
            System.out.println(e.getCustomMessage());
            userReport.setNameValid(false);
        }


        //        2. Surname check

        try {
            UserParametrsCheck.surnameCheck(user);
        } catch (SurNameException e) {
            System.out.println(e.getCustomMessage());
            userReport.setSurnameValid(false);
        }

        //         3. Age check

        try {
            UserParametrsCheck.ageCheck(user);
        } catch (AgeException e) {
            System.out.println(e.getCustomMessage());
            userReport.setAgeValid(false);
        }

        //        4. Sex check

        try {
            UserParametrsCheck.sexCheck(user);
        } catch (SexException e) {
            System.out.println(e.getCustomMessage());
            userReport.setSexValid(false);
        }


        //        5. Education check

        try {
            UserParametrsCheck.educationCheck(user);
        } catch (EducationException e) {
            System.out.println(e.getCustomMessage());
            userReport.setEducationValid(false);
        }
        userReport.printReport();
    }


}





