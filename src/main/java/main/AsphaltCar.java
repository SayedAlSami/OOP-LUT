package main;

public class AsphaltCar extends RallyCar {

    private final double tireGrip;

    public AsphaltCar(String make, String model, int horsepower, double tireGrip) {
        super(make, model, horsepower);
        this.tireGrip = tireGrip;
    }

    @Override
    public double calculatePerformance() {
        return horsepower * 0.8 + tireGrip * 20;
    }
}