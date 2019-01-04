package com.htp.hometask4;

import java.util.Arrays;


public class Generator {

    public int[] speedArray = new int[3];
    public int[] passangerArray = new int[3];
    public int[] ticketCostArray = new int[3];
    public String[] nameArray = new String[3];
    private String[] nameArray1 = new String[3];
    private String[] nameArray2 = new String[3];
    private String transName;

    public Generator() {
    }

    public Generator(int[] speedArray, int[] passangerArray, int[] ticketCostArray, String[] nameArray) {
        this.speedArray = speedArray;
        this.passangerArray = passangerArray;
        this.ticketCostArray = ticketCostArray;
        this.nameArray = nameArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Generator generator = (Generator) o;

        if (!Arrays.equals(speedArray, generator.speedArray)) return false;
        if (!Arrays.equals(passangerArray, generator.passangerArray)) return false;
        if (!Arrays.equals(ticketCostArray, generator.ticketCostArray)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(nameArray, generator.nameArray)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(nameArray1, generator.nameArray1)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(nameArray2, generator.nameArray2)) return false;
        return transName != null ? transName.equals(generator.transName) : generator.transName == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(speedArray);
        result = 31 * result + Arrays.hashCode(passangerArray);
        result = 31 * result + Arrays.hashCode(ticketCostArray);
        result = 31 * result + Arrays.hashCode(nameArray);
        result = 31 * result + Arrays.hashCode(nameArray1);
        result = 31 * result + Arrays.hashCode(nameArray2);
        result = 31 * result + (transName != null ? transName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Generator{" +
                "speedArray=" + Arrays.toString(speedArray) +
                ", passangerArray=" + Arrays.toString(passangerArray) +
                ", ticketCostArray=" + Arrays.toString(ticketCostArray) +
                ", nameArray=" + Arrays.toString(nameArray) +
                ", nameArray1=" + Arrays.toString(nameArray1) +
                ", nameArray2=" + Arrays.toString(nameArray2) +
                ", transName='" + transName + '\'' +
                '}';
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    // 1. Speed sorting

    public void speedSorting() {
        for (int i = 0; i < nameArray.length; i++) {
            nameArray1[i] = nameArray[i];
        }


        for (int gap = speedArray.length / 2; gap > 0; gap /= 2) {
            int j;
            for (int i = gap; i < speedArray.length; i++) {
                int temp = speedArray[i];
                String temp1 = nameArray1[i];
                for (j = i; j >= gap && speedArray[j - gap] > temp; j -= gap) {
                    speedArray[j] = speedArray[j - gap];
                    nameArray1[j] = nameArray1[j - gap];
                }
                speedArray[j] = temp;
                nameArray1[j] = temp1;
            }
        }
        System.out.println("1. Speed sorting:");
        for (int i = 0; i < speedArray.length; i++) {
            System.out.println(nameArray1[i] + speedArray[i] + "km/h ");
        }
        System.out.println();
    }
// 2. Passanger sorting

    public void passangerSorting() {
        for (int i = 0; i < nameArray.length; i++) {
            nameArray2[i] = nameArray[i];
        }
        int temp;
        String temp1;

        for (int i = 0; i < passangerArray.length; i++) {
            for (int j = 1; j < (passangerArray.length - i); j++) {

                if (passangerArray[j - 1] > passangerArray[j]) {

                    temp = passangerArray[j - 1];
                    passangerArray[j - 1] = passangerArray[j];
                    passangerArray[j] = temp;

                    temp1 = nameArray2[j - 1];
                    nameArray2[j - 1] = nameArray2[j];
                    nameArray2[j] = temp1;
                }
            }
        }
        System.out.println("2. Passanger sorting:");
        for (int i = 0; i < passangerArray.length; i++) {
            System.out.println(nameArray2[i] + passangerArray[i] + " persons");
        }
        System.out.println();
    }

    // 3. min-max

    public void minMaxSearch() {


        int max = 0;
        int min = ticketCostArray[0];
        String nameMax, nameMin;
        nameMax = nameArray[0];
        nameMin = nameArray[0];
        for (int i = 0; i < ticketCostArray.length; i++) {
            if (ticketCostArray[i] < min) {
                min = ticketCostArray[i];
                nameMin = nameArray[i];
            }
            if (ticketCostArray[i] > max) {
                max = ticketCostArray[i];
                nameMax = nameArray[i];
            }
        }
        System.out.println("3. Search for min-max price values of the trip:");
        System.out.println("Min price - " + nameMin + min + "$");
        System.out.println("Max price - " + nameMax + max + "$");
        System.out.println();
    }


    }





