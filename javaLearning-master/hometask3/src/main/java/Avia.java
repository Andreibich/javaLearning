import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Avia {
    private String[][][] rasp;
    private String[] city;
    private String[] day;
    private String[] type;
    private String[] race;
    private int b;

    public Avia() {
    }

    public Avia(String[][][] rasp, String[] city, String[] day, String[] type, String[] race, int b) {
        this.rasp = rasp;
        this.city = city;
        this.day = day;
        this.type = type;
        this.race = race;
        this.b = b;
    }

    public String[][][] getRasp() {
        return rasp;
    }

    public void setRasp(String[][][] rasp) {
        this.rasp = rasp;
    }

    public String[] getCity() {
        return city;
    }

    public void setCity(String[] city) {
        this.city = city;
    }

    public String[] getDay() {
        return day;
    }

    public void setDay(String[] day) {
        this.day = day;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String[] getRace() {
        return race;
    }

    public void setRace(String[] race) {
        this.race = race;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Avia avia = (Avia) o;

        if (b != avia.b) return false;
        if (!Arrays.deepEquals(rasp, avia.rasp)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(city, avia.city)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(day, avia.day)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(type, avia.type)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(race, avia.race);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(rasp);
        result = 31 * result + Arrays.hashCode(city);
        result = 31 * result + Arrays.hashCode(day);
        result = 31 * result + Arrays.hashCode(type);
        result = 31 * result + Arrays.hashCode(race);
        result = 31 * result + b;
        return result;
    }

    @Override
    public String toString() {
        return "Avia{" +
                "rasp=" + Arrays.toString(rasp) +
                ", city=" + Arrays.toString(city) +
                ", day=" + Arrays.toString(day) +
                ", type=" + Arrays.toString(type) +
                ", race=" + Arrays.toString(race) +
                ", b=" + b +
                '}';
    }

    public void list_a(String a1) {
        for (int i = 0; i < 5; i++) {
            if (getCity()[i] == a1) {
                b = i;
            }
        }

        System.out.println("Task 1:");
        System.out.println("Point of destination - " + a1);
        System.out.println("Flight number - " + getRace()[b] + " , type of airplane - " + getType()[b]);
        System.out.println("Timetable on a week:");
        for (int i = 0; i < 7; i++) {
            System.out.print(getDay()[i] + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(getRasp()[i][b][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void list_b(String a2) {
        for (int i = 0; i < 5; i++) {
            if (getDay()[i] == a2) {
                b = i;
            }
        }
        System.out.println("Task 2:");
        System.out.println("Day - " + a2);
        for (int i = 0; i < 5; i++) {
            System.out.println("Point of destination - " + getCity()[i]);
            System.out.println("Flight number - " + getRace()[i] + " , type of airplane - " + getType()[i]);
            System.out.print("Departure time - ");
            for (int j = 0; j < 3; j++) {
                System.out.print(getRasp()[b][i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void list_c(String a3, String b3) {
        for (int i = 0; i < 5; i++) {
            if (getDay()[i] == a3) {
                b = i;
            }
        }
        System.out.println("Task 3:");
        System.out.println("Day - " + a3);
        System.out.println("Departure time after " + b3);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println("Point of destination - " + getCity()[i]);
            System.out.println("Flight number - " + getRace()[i] + " , type of airplane - " + getType()[i]);
            System.out.print("Departure time - ");
            for (int j = 0; j < 3; j++) {


                if (Double.parseDouble(b3) < Double.parseDouble(getRasp()[b][i][j])) {
                    System.out.print(getRasp()[b][i][j] + " ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }


    public void sort_1() {
        Arrays.sort(getType());
        for (int i = 0; i < getType().length; i++) {
            System.out.print(getType()[i] + "  ");
        }
        System.out.println();
    }

    public void sort_2() {

        for (int i = 1; i < getType().length; i++) {
            String key = getType()[i];
            int j = i - 1;
            while (j >= 0 && (key.compareTo(getType()[j]) < 0)) {
                getType()[j + 1] = getType()[j];
                j--;
            }
            getType()[j + 1] = key;
        }
        for (int i = 0; i < getType().length; i++) {
            System.out.print(getType()[i] + "  ");
        }
        System.out.println();
    }

    public void sort_3() {
        List colList = new ArrayList(Arrays.asList(getType()));
        Collections.sort(colList);
        System.out.println(colList);
        System.out.println();
    }

}







