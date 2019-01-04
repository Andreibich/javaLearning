package com.htp.lesson6task.domain;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import java.sql.SQLOutput;

public abstract class Technics<K, N> {
    protected K id;
    protected N value;
    protected EnumTechics brand;

    public Technics() {
    }

    public Technics(K id, N value) {
        this.id = id;
        this.value = value;
    }

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public N getValue() {
        return value;
    }

    public void setValue(N value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Technics<?, ?> technics = (Technics<?, ?>) o;

        if (id != null ? !id.equals(technics.id) : technics.id != null) return false;
        if (value != null ? !value.equals(technics.value) : technics.value != null) return false;
        return brand == technics.brand;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Technics{" +
                "id=" + id +
                ", value=" + value +
                ", brand=" + brand +
                '}';
    }

    public void genericMethod(/*String x1, Integer x2*/) {
        System.out.println(this.getId());
        System.out.println(this.getValue());

    }
}
