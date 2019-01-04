public class Transport extends PublicTransport{
    private String way;
    private int distance;

    public Transport() {
    }

    public Transport(String way, int distance) {
        this.way = way;
        this.distance = distance;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (distance != transport.distance) return false;
        return way != null ? way.equals(transport.way) : transport.way == null;
    }

    @Override
    public int hashCode() {
        int result = way != null ? way.hashCode() : 0;
        result = 31 * result + distance;
        return result;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "way='" + way + '\'' +
                ", distance=" + distance +
                '}';
    }

    @Override
    public void type() {
        System.out.println("The comparison of transport characteristics for definite route :\n");
    }

    @Override
    public void trip(String way, int distance) {
        System.out.println("Trip: " + way);
        System.out.println("Distance - " + distance + " kм");
    }
}
