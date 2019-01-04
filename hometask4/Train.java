package com.htp.hometask4;

public class Train extends Transport implements TransportType{
    private int passangers;
    private int speed;
    private String fuel;
    private int ticketCost;

    public Train() {
    }

    public Train(int passangers, int speed, String fuel, int ticketCost) {
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

        Train train = (Train) o;

        if (passangers != train.passangers) return false;
        if (speed != train.speed) return false;
        if (ticketCost != train.ticketCost) return false;
        return fuel != null ? fuel.equals(train.fuel) : train.fuel == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passangers;
        result = 31 * result + speed;
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + ticketCost;
        return result;
    }

    @Override
    public String toString() {
        return "Train{" +
                "passangers=" + passangers +
                ", speed=" + speed +
                ", fuel='" + fuel + '\'' +
                ", ticketCost=" + ticketCost +
                '}';
    }

    @Override
    public void transportType() {
        System.out.println("Type - Train");
    }

    @Override
    public void trip(String way, int distance) {
        super.trip(way, distance);
        System.out.println("Speed - " + speed + " км/ч");
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
