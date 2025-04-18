package me.tyfcho.rideControl.ride;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the registration and retrieval of rides.
 */
public class RideManager {
    private final Map<String, Ride> rides = new HashMap<>();

    /**
     * Registers a new ride.
     *
     * @param id   The unique identifier for the ride.
     * @param name The name of the ride.
     * @return The registered Ride object.
     * @throws IllegalArgumentException If a ride with the same ID already exists.
     */
    public Ride registerRide(String id, String name) {
        if (rides.containsKey(id)) {
            throw new IllegalArgumentException("A ride with ID '" + id + "' already exists.");
        }
        Ride ride = new Ride(id, name);
        rides.put(id, ride);
        return ride;
    }

    /**
     * Retrieves a ride by its ID.
     *
     * @param id The unique identifier of the ride.
     * @return The Ride object, or null if not found.
     */
    public Ride getRide(String id) {
        return rides.get(id);
    }

    /**
     * Lists all registered rides.
     *
     * @return A map of ride IDs to Ride objects.
     */
    public Map<String, Ride> listRides() {
        return rides;
    }

    /**
     * Evaluates a specific logic gate for a given ride using the provided inputs.
     *
     * @param rideId The unique identifier of the ride.
     * @param gateIndex The index of the logic gate to evaluate.
     * @param inputs The boolean inputs for the logic gate.
     * @return The result of the logic gate evaluation.
     * @throws IllegalArgumentException If the ride is not found or the gate index is invalid.
     */
    public boolean evaluateRideLogicGate(String rideId, int gateIndex, boolean... inputs) {
        Ride ride = getRide(rideId);
        if (ride == null) {
            throw new IllegalArgumentException("Ride with ID '" + rideId + "' not found.");
        }
        return ride.evaluateLogicGate(gateIndex, inputs);
    }

    /**
     * Removes a ride by its unique identifier.
     *
     * @param id The unique identifier of the ride to remove.
     * @return The removed Ride object, or null if no ride was found with the given ID.
     */
    public Ride removeRide(String id) {
        return rides.remove(id);
    }

}