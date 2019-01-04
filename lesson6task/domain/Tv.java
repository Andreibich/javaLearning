package com.htp.lesson6task.domain;

import com.htp.lesson6task.util.Interface1;
import com.htp.lesson6task.util.Interface2;

public class Tv extends Technics<String, Integer> implements Interface1, Interface2 {
    //    private String name;
    private int weight;


    public Tv(String id, Integer value, int weight) {
        super(id, value);
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tv tv = (Tv) o;

        return weight == tv.weight;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "weight=" + weight +
                ", brand=" + brand +
                '}';
    }

    @Override
    public void method1() {
        System.out.print("1 - ");
    }

    @Override
    public void method2() {
        System.out.println("TV");
    }

    @Override
    public void genericMethod() {
        brand = EnumTechics.PANASONIC;
        System.out.println("name = " + getId());
        System.out.println("cost = " + getValue() + " $");
        System.out.println("brand = " + brand.name());
        System.out.println("weight = " + weight + " kg");
        System.out.println("Is this BOSCH? " + brand.isBosch() + "\n");
    }
}

