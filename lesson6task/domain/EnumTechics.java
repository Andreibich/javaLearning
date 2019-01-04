package com.htp.lesson6task.domain;

public enum EnumTechics {
    LG(1), PANASONIC(2), BOSCH(3), SAMSUNG(4);

    private int Number;

    EnumTechics() {
    }

    EnumTechics(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    @Override
    public String toString() {
        return "EnumTechics{" +
                "Number=" + Number +
                '}';
    }

    public boolean isBosch() {
        switch (this) {
            case BOSCH:
                return true;
            case LG:
            case SAMSUNG:
            case PANASONIC:
            default:
                return false;
        }
    }
}
