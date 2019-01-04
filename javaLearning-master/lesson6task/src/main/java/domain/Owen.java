package domain;

import util.Interface1;
import util.Interface2;

public class Owen extends Technics<String, Integer> implements Interface1, Interface2 {
    private double depth;

    // getters here


    public Owen() {
    }

    public Owen(String id, Integer value, double depth) {
        super(id, value);
        this.depth = depth;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Owen owen = (Owen) o;

        return Double.compare(owen.depth, depth) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Owen{" +
                "depth=" + depth +
                ", id=" + id +
                ", value=" + value +
                ", brand=" + brand +
                '}';
    }

    public static class Builder {
        private Owen newOwen;

        public Builder() {
            newOwen = new Owen();
        }

        public Builder addDepth(Double depth) {
            newOwen.depth = depth;
            return this;
        }

        public Builder addId(String id) {
            newOwen.id = id;
            return this;
        }

        public Builder addValue(Integer value) {
            newOwen.value = value;
            return this;
        }

        public Owen build() {
            return newOwen;
        }
    }


    @Override
    public void method1() {
        System.out.print("3. ");
    }

    @Override
    public void method2() {
        System.out.println("Owen");
    }

    @Override
    public void genericMethod() {
        brand = EnumTechics.BOSCH;
        System.out.println("name - " + getId());
        System.out.println("price - " + getValue() + " $");
        System.out.println("brand - " + brand.name());
        System.out.println("height - " + depth + " m");
        System.out.println("Is this BOSCH? " + brand.isBosch() + "\n");
    }
}
