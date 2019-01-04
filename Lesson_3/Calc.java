package com.htp;

public class Calc {
    public static void main(String[] args) {
        Auto raschet = new Auto();
        Auto raschet1 = new Auto();
        System.out.println("Марка и модель - " + Auto.marka + " " + Auto.model);
//        System.out.println(raschet.sum1);

   //     Auto raschet = new Auto();

        System.out.println("Старая стоимость машины - " + raschet.sum());
        System.out.println("Новая стоимость машины - " + raschet1.calc1(5,10,12,8,25));
        raschet1.setPart1(5);
        System.out.println(" стоимость машины - " + raschet1.sum());
    }
}
