package me.tyfcho.rideControl.ride;

import me.tyfcho.rideControl.logic.LogicGate;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a ride in the RideControl plugin.
 */
public class Ride {
    private final String id;
    private final String name;
    private final List<LogicGate> logicGates;

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

    public List<LogicGate> getLogicGates() {
        return logicGates;
    }

    public void addLogicGate(LogicGate logicGate) {
        logicGates.add(logicGate);
    }

    public boolean evaluateLogicGate(int index, boolean... inputs) {
        if (index < 0 || index >= logicGates.size()) {
            throw new IndexOutOfBoundsException("Invalid logic gate index.");
        }
        return logicGates.get(index).evaluate(inputs);
    }
}