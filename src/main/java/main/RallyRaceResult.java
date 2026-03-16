package main;

import java.util.LinkedHashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {

    private final String raceName;
    private final String location;
    private final Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.results = new LinkedHashMap<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }
}