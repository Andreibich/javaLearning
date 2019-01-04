package com.htp.lesson9.hometask9.util;


import com.htp.lesson9.hometask9.domain.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Andrei", "Bich1", 100, "male", "higher");
        System.out.println(user1.toString());
        Validator.checkUser(user1);

        System.out.println("\n");

        User user2 = new User("Anton2", "Tchaikovsky", 32, "males", "special");
        System.out.println(user2.toString());
        Validator.checkUser(user2);


    }
}