package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    public static double calculateAveragePoints(List<Driver> drivers) {
        int total = drivers.stream().mapToInt(Driver::getPoints).sum();
        return (double) total / drivers.size();
    }

    public static String mostSuccessfulCountry(List<Driver> drivers) {

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver d : drivers) {
            countryPoints.put(
                d.getCountry(),
                countryPoints.getOrDefault(d.getCountry(), 0) + d.getPoints()
            );
        }

        return countryPoints.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public static int getTotalDrivers() {
        return Driver.getTotalDrivers();
    }

    public static int getTotalRaces() {
        return ChampionshipManager.getTotalRaces();
    }
}