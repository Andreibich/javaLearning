public class Plane extends Transport implements TransportType{
    private int passangers;
    private int speed;
    private String fuel;
    private int ticketCost;

    public Plane() {
    }

    public Plane(int passangers, int speed, String fuel, int ticketCost) {
        this.passangers = passangers;
        this.speed = speed;
        this.fuel = fuel;
        this.ticketCost = ticketCost;
    }

    public int getPassangers() {
        return passangers;
    }

    public void setPassangers(int passangers) {
        this.passangers = passangers;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(int ticketCost) {
        this.ticketCost = ticketCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (passangers != plane.passangers) return false;
        if (speed != plane.speed) return false;
        if (ticketCost != plane.ticketCost) return false;
        return fuel != null ? fuel.equals(plane.fuel) : plane.fuel == null;
    }

    @Override
    public int hashCode() {
        int result = passangers;
        result = 31 * result + speed;
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + ticketCost;
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "passangers=" + passangers +
                ", speed=" + speed +
                ", fuel='" + fuel + '\'' +
                ", ticketCost=" + ticketCost +
                '}';
    }


    @Override
    public void transportType() {
        System.out.println("Type - Airplane");
    }

    @Override
    public void trip(String way, int distance) {
        super.trip(way, distance);
        System.out.println("Speed - " + speed + " km/h");
        System.out.printf("Trip time - %.1f ч\n", (double) distance / speed);

    }

    public void altTrip() {
        System.out.println("Alternative trip isn't defined\n");
    }

    public void altTrip(String way, int distance) {
        System.out.println("Alternative trip - " + way + " distance - " + distance + " км");
        System.out.printf("Trip time - %.1f ч\n\n", (double) distance / speed);
    }

}
