package domain;

import util.Interface1;
import util.Interface2;

public class Dishwasher extends Technics<String, Integer> implements Interface1, Interface2 {
    private double height;

    private static Dishwasher instance;

    private Dishwasher() {
    }

    private Dishwasher(String id, Integer value, double height) {
        super(id, value);
        this.height = height;
    }
    public static Dishwasher getInstance(String id, Integer value, double height) {
        if (instance == null) {
            synchronized (Dishwasher.class) {
                if (instance == null) {
                    instance = new Dishwasher(id, value, height);
                }
            }
        }
        return instance;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dishwasher that = (Dishwasher) o;

        return Double.compare(that.height, height) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Dishwasher{" +
                "height=" + height +
                ", brand=" + brand +
                '}';
    }

    @Override
    public void method1() {
        System.out.print("2 - ");
    }

    @Override
    public void method2() {
        System.out.println("Dishwasher");
    }

    @Override
    public void genericMethod() {
        brand = EnumTechics.LG;
        System.out.println("name - " + getId());
        System.out.println("price - " + getValue() + " $");
        System.out.println("brand - " + brand.name());
        System.out.println("height - " + height + " m");
        System.out.println("Is this BOSCH? " + brand.isBosch() + "\n");
    }
}
