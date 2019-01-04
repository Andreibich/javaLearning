package domain;

import util.Interface1;
import util.Interface2;

public class Fridge extends Technics<String, Integer> implements Interface1, Interface2 {
    private int volume;

    public Fridge(String id, Integer value, int volume) {
        super(id, value);
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Fridge fridge = (Fridge) o;

        return volume == fridge.volume;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + volume;
        return result;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "volume=" + volume +
                ", brand=" + brand +
                '}';
    }

    @Override
    public void method1() {
        System.out.print("4 - ");
    }

    @Override
    public void method2() {
        System.out.println("Fridge");
    }

    @Override
    public void genericMethod() {
        brand = EnumTechics.SAMSUNG;
        System.out.println("name - " + getId());
        System.out.println("price - " + getValue() + " $");
        System.out.println("brand - " + brand.name());
        System.out.println("height - " + volume + " L");
        System.out.println("Is this BOSCH? " + brand.isBosch() + "\n");
    }
}
