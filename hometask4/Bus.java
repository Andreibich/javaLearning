package com.htp.hometask4;

public class Bus extends Transport  implements TransportType{
    private int passangers;
    private static int speed;
    private String fuel;
    private int ticketCost;

    public Bus() {
    }

    public Bus(int passangers, int speed, String fuel, int ticketCost) {
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
        if (!super.equals(o)) return false;

        Bus bus = (Bus) o;

        if (passangers != bus.passangers) return false;
        if (ticketCost != bus.ticketCost) return false;
        return fuel != null ? fuel.equals(bus.fuel) : bus.fuel == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passangers;
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + ticketCost;
        return result;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "passangers=" + passangers +
                ", fuel='" + fuel + '\'' +
                ", ticketCost=" + ticketCost +
                '}';
    }

    @Override
    public void transportType() {
        System.out.println("Type - Bus");
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