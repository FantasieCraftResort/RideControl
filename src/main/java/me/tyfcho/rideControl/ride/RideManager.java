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
}