package me.tyfcho.rideControl.ride;

import me.tyfcho.rideControl.logic.LogicGate;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a ride in the RideControl plugin.
 * Each ride has a unique identifier, a name, and a list of associated logic gates.
 * Logic gates are used to control the behavior of the ride based on boolean inputs.
 */
public class Ride {
    private final String id; // Unique identifier for the ride
    private final String name; // Name of the ride
    private final List<LogicGate> logicGates; // List of logic gates associated with the ride

    /**
     * Constructs a new Ride with the specified ID and name.
     *
     * @param id   The unique identifier for the ride.
     * @param name The name of the ride.
     */
    public Ride(String id, String name) {
        this.id = id;
        this.name = name;
        this.logicGates = new ArrayList<>();
    }

    /**
     * Gets the unique identifier of the ride.
     *
     * @return The ride's unique ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the ride.
     *
     * @return The ride's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of logic gates associated with the ride.
     *
     * @return A list of logic gates.
     */
    public List<LogicGate> getLogicGates() {
        return logicGates;
    }

    /**
     * Adds a logic gate to the ride after validation.
     *
     * @param logicGate The logic gate to add.
     * @throws IllegalArgumentException If the logic gate is invalid.
     */
    public void addLogicGate(LogicGate logicGate) {
        validateLogicGate(logicGate);
        logicGates.add(logicGate);
    }

    /**
     * Validates a logic gate before adding it to the ride.
     *
     * @param logicGate The logic gate to validate.
     * @throws IllegalArgumentException If the logic gate is null or invalid.
     */
    private void validateLogicGate(LogicGate logicGate) {
        if (logicGate == null) {
            throw new IllegalArgumentException("Logic gate cannot be null.");
        }
        // Add additional validation logic here if needed (e.g., check specific properties of the logic gate)
    }

    /**
     * Evaluates a specific logic gate in the ride using the provided inputs.
     *
     * @param index  The index of the logic gate to evaluate.
     * @param inputs The boolean inputs for the logic gate.
     * @return The result of the logic gate evaluation.
     * @throws IndexOutOfBoundsException If the index is invalid.
     */
    public boolean evaluateLogicGate(int index, boolean... inputs) {
        if (index < 0 || index >= logicGates.size()) {
            throw new IndexOutOfBoundsException("Invalid logic gate index.");
        }
        return logicGates.get(index).evaluate(inputs);
    }
}