import java.util.Comparator;

public class TransportComparator implements Comparator<TransportName> {

    public TransportComparator() {
    }

    @Override
    public String toString() {
        return "TransportComparator{}";
    }

    @Override
    public int compare(TransportName o1, TransportName o2) {
        if (o1.getTransName().length() > o2.getTransName().length()) {
            return 1;

        } else {if (o1.getTransName().length() == o2.getTransName().length()){
            return 0;}
        else {return -1;}}
    }
}
