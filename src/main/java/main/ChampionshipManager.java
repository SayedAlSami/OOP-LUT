package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private final List<Driver> drivers;
    private final List<RallyRaceResult> races;

    private static int totalRaces = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRaceResult(RallyRaceResult race) {
        races.add(race);
        totalRaces++;
    }

    public List<Driver> getStandings() {
        drivers.sort(Comparator.comparingInt(Driver::getPoints).reversed());
        return drivers;
    }

    public Driver getLeadingDriver() {
        return getStandings().get(0);
    }

    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public List<RallyRaceResult> getRaces() {
        return races;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }
}