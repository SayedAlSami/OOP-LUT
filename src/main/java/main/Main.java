package main;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelCar = new GravelCar("Toyota", "GR Yaris", 380, 8.5);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20 N", 390, 9.0);

        Driver ogier = new Driver("Sebastien Ogier", "France", gravelCar);
        Driver rovanpera = new Driver("Kalle Rovanpera", "Finland", gravelCar);
        Driver tanak = new Driver("Ott Tanak", "Estonia", asphaltCar);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        // Race 1
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyvaskyla");
        race1.recordResult(ogier, 1, 25);
        race1.recordResult(tanak, 2, 18);
        race1.recordResult(rovanpera, 3, 15);
        race1.recordResult(neuville, 4, 12);

        manager.addRaceResult(race1);

        // Race 2
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race2.recordResult(rovanpera, 1, 25);
        race2.recordResult(neuville, 2, 18);
        race2.recordResult(ogier, 3, 15);
        race2.recordResult(tanak, 4, 12);

        manager.addRaceResult(race2);

        // Standings
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        for (Driver d : manager.getStandings()) {
            System.out.println(d);
        }

        // Leader
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeadingDriver());

        // Statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipStatistics.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRaces());
        System.out.println("Average Points Per Driver: " +
                ChampionshipStatistics.calculateAveragePoints(manager.getDrivers()));
        System.out.println("Most Successful Country: " +
                ChampionshipStatistics.mostSuccessfulCountry(manager.getDrivers()));
        System.out.println("Total Championship Points: " +
                manager.getTotalChampionshipPoints());

        // Race Results
        System.out.println("\n===== RACE RESULTS =====");

        for (RallyRaceResult race : manager.getRaces()) {

            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");

            int position = 1;

            for (Map.Entry<Driver, Integer> entry : race.getResults().entrySet()) {

                System.out.println(" Position " + position + ": "
                        + entry.getKey().getName()
                        + " - " + entry.getValue() + " points");

                position++;
            }
        }

        // Car Performance
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}