package main;

public class Driver {

    private final String name;
    private final String country;
    private int points;
    private RallyCar car;

    private static int totalDrivers = 0;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0;
        totalDrivers++;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPoints() {
        return points;
    }

    public RallyCar getCar() {
        return car;
    }

    public void switchCar(RallyCar car) {
        this.car = car;
    }

    public void addPoints(int pts) {
        this.points += pts;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    @Override
    public String toString() {
        return name + " (" + country + "): " + points + " points";
    }
}