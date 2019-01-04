package com.htp;

public class Auto {
    public static String marka = "Mersedes";
    public static String model = "E63 AMG";
    public int part1 = 15;
    public int part2 = 10;
    public int part3 = 12;
    public int part4 = 8;
    public int part5 = 25;
    public int sum1;



    public int getPart1() {
        return part1;
    }

    public void setPart1(int part1) {
        this.part1 = part1;
    }

    public int getPart2() {
        return part2;
    }

    public void setPart2(int part2) {
        this.part2 = part2;
    }

    public int getPart3() {
        return part3;
    }

    public void setPart3(int part3) {
        this.part3 = part3;
    }

    public int getPart4() {
        return part4;
    }

    public void setPart4(int part4) {
        this.part4 = part4;
    }

    public int getPart5() {
        return part5;
    }

    public void setPart5(int part5) {
        this.part5 = part5;
    }

    public int calc1(int part1, int part2, int part3, int part4, int part5) {
        return part1+part2+part3+part4+part5;}

   // sum1=part1+part2+part3+part4+part5;
    //sum1=part1+part2+part3+part4+part5;

    public /*static*/ int sum(){

        return part1+part2+part3+part4+part5;
    }
}
