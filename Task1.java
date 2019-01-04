package com.htp;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
//  1
//        int mass = 100;
//        double g = 9.8d;
//        double rel = 0.16;
//        double weight = mass * rel * g;
//        System.out.println("1. Your weight (N) " + weight);

//  2
//       Scanner in = new Scanner(System.in);
//        System.out.print("2. Enter the number of elements - ");
//        int a2 = in.nextInt();
//        int c2[] = new int [a2];
//        for (int b2=0; b2<=a2-1; b2++) {
//            System.out.printf("2. Enter %d element - ", b2+1);
//            c2[b2] = in.nextInt();
//        }
//        System.out.print("2. ");
//        for (int b2=0; b2<=a2-1; b2++) {
//            double d2=c2[b2]*1.1;
//            System.out.printf(" %d element of array - %.1f \n", b2+1, d2);
//        }


//  3
//        Scanner in = new Scanner(System.in);
//        System.out.print("3. Enter the number - ");
//        String a3 = in.nextLine();
//        String b3 = new StringBuilder(a3).reverse().toString();
//        if (a3.equals(b3)){
//            System.out.println("3. This is palindrom");
//        }
//        else {
//            System.out.println("3. This isn't  palindrom");
//        }

//  4
//        int a4;
//        int b4;
//        for (a4 = 1; a4 <= 100; a4++) {
//            b4 = a4 % 2;
//            if (b4 == 0) {
//                System.out.println("4. " + a4);
//            }
//        }


//  5
//        int a5;
//        int b5;
//        for (a5 = 1; a5 <= 15; a5++) {
//            b5 = a5 % 2;
//            if (b5 > 0) {
//                System.out.println("5. " + a5);
//            }
//        }

//  6
//        int a6;
//        for (a6 = 2; a6 <= 100; a6 = a6 + 2) {
//            System.out.println("6. " + a6);
//        }

//  7
//        int a7;
//        int sum7 = 0;
//        for (a7 = 20; a7 <= 200; a7++) {
//            sum7 = sum7 + a7;
//        }
//        System.out.println("7. The summ from 20 to 200 - " + sum7);
//  8
//        int a8;
//        for (a8 = 1; a8 <= 12; a8++) {
//            if (a8 == 1) {
//                System.out.println("8. " + a8 + " january");
//            }
//            if (a8 == 2) {
//                System.out.println("8. " + a8 + " febrary");
//            }
//            if (a8 == 3) {
//                System.out.println("8. " + a8 + " march");
//            }
//            if (a8 == 4) {
//                System.out.println("8. " + a8 + " april");
//            }
//            if (a8 == 5) {
//                System.out.println("8. " + a8 + " may");
//            }
//            if (a8 == 6) {
//                System.out.println("8. " + a8 + " june");
//            }
//            if (a8 == 7) {
//                System.out.println("8. " + a8 + " july");
//            }
//            if (a8 == 8) {
//                System.out.println("8. " + a8 + " august");
//            }
//            if (a8 == 9) {
//                System.out.println("8. " + a8 + " semtember");
//            }
//            if (a8 == 10) {
//                System.out.println("8. " + a8 + " october");
//            }
//            if (a8 == 11) {
//                System.out.println("8. " + a8 + " november");
//            }
//            if (a8 == 12) {
//                System.out.println("8. " + a8 + " december");
//            }
//
//        }

//  9
//        int a9 = 1;
//        int b9 = 2;
//        int c9 = a9;
//        System.out.println("9. " + a9 + " " + b9);
//        a9 = b9;
//        b9 = c9;
//        System.out.println("9. " + a9 + " " + b9);

//  10
//        int a10 = 10;
//        int b10 = 20;
//        int sum10 = a10 + b10;
//        System.out.println("10. The summ " + sum10);

//  11
//        int a11 = 5;
//        int b11 = 11;
//        int c11 = 9;
//        int d11;
//        if (a11 <= b11) {
//            d11 = b11;
//        } else {
//            d11 = a11;
//        }
//        if (d11 <= c11) {
//            d11 = c11;
//        }
//        System.out.println("11. Max value " + d11);

//  12
//        boolean a12 = true;
//        boolean b12 = false;
//        if (a12 == true) {
//            System.out.println("12. false " + a12);
//        } else {
//            System.out.println("12. true " + a12);
//        }
//        if (b12 == true) {
//            System.out.println("12. false " + b12);
//        } else {
//            System.out.println("12. true " + b12);
//        }
//  13
//        String a13 = "line1";
//        String b13 = "line2";
//        String c13 = a13 + b13;
//        System.out.println("13. " + c13);

//  14
//        int a14 = 3;
//        int b14 = 2;
//        System.out.println("14. " + a14 + " " + b14);
//        if (a14 > b14) {
//            a14 = a14 + 3;
//            System.out.println("14. " + a14 + " " + b14);
//        } else {
//            b14 = b14 + 8;
//            System.out.println("14. " + a14 + " " + b14);
//        }

//  15
//        int a15;
//        for (a15 = 1; a15 <= 100; a15++) {
//            System.out.println("15. " + a15);
//        }
//        a15 = 1;
//        while (a15 <= 100) {
//            System.out.println("15. " + a15);
//            a15++;
//        }
//        a15 = 1;
//        do {
//            System.out.println("15. " + a15);
//            a15++;
//        }
//        while (a15 <= 100);

//  16
//        Scanner in = new Scanner(System.in);
//        System.out.print("16. Min value - ");
//        int a16 = in.nextInt();
//        System.out.print("16. Max value - ");
//        int b16 = in.nextInt();
//        System.out.print("16. Step - ");
//        int c16 = in.nextInt();
//        for (int i16 = a16; i16 <= b16; i16 = i16 + c16) {
//            System.out.print(i16 + " ");
//        }

//  17
//        Scanner in = new Scanner(System.in);
//        System.out.print("17. Enter the number of elements - ");
//        int a17 = in.nextInt();
//        int c17[] = new int [a17];
//        double max17=0;
//        for (int b17=0; b17<=a17-1; b17++) {
//            System.out.printf("17. Enter %d element - ", b17+1);
//            c17[b17] = in.nextInt();
//            if (c17[b17]>=max17) {
//                max17=c17[b17];
//            }
//        }
//        double d17;
//        System.out.println("Max - " + max17);
//        for (int b17=0; b17<=a17-1; b17++) {
//            d17=c17[b17]/max17;
//            System.out.printf("17. (%d element of array / max) = %.3f \n", b17+1, d17);
//        }

//  18
//        Scanner in = new Scanner(System.in);
//        System.out.print("18. Rubles - ");
//        int a18 = in.nextInt();
//        System.out.print("18. Exchange rate - ");
//        float b18 = in.nextFloat();
//        float c18 = a18*b18;
//        System.out.println("18. Dollars - " + c18);

//  ad
        Scanner in = new Scanner(System.in);
        System.out.print("AD. Enter the number of days  - ");
        int valueOfHoursOnADay = 24;
        int valueOfMinutesOnAHour = 60;
        int valueOfSecondsOnAMinute = 60;
        int ad = in.nextInt();
        int hours = ad * valueOfHoursOnADay;
        int minutes = hours * valueOfMinutesOnAHour;
        int seconds = minutes * valueOfSecondsOnAMinute;
        System.out.printf("AD. In %d days - %d hours, %d minutes or %d seconds", ad, hours, minutes, seconds);

    }
}
