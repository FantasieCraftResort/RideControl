package me.tyfcho.rideControl.ride;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a ride in the RideControl plugin.
 */
public class Ride {
    private final String id;
    private final String name;
    private final List<String> logicGates;

    /**
     * Constructs a new Ride.
     *
     * @param id   The unique identifier for the ride.
     * @param name The name of the ride.
     */
    public Ride(String id, String name) {
        this.id = id;
        this.name = name;
        this.logicGates = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getLogicGates() {
        return logicGates;
    }

    /**
     * Adds a logic gate to the ride.
     *
     * @param logicGate The logic gate to add.
     */
    public void addLogicGate(String logicGate) {
        logicGates.add(logicGate);
    }
}