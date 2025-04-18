package me.tyfcho.rideControl.ride;

import me.tyfcho.rideControl.logic.LogicGate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RideManagerTest {
    private RideManager rideManager;

    @BeforeEach
    void setUp() {
        rideManager = new RideManager();
    }

    @Test
    void testRegisterRide() {
        Ride ride = rideManager.registerRide("ride1", "Roller Coaster");
        assertNotNull(ride);
        assertEquals("ride1", ride.getId());
        assertEquals("Roller Coaster", ride.getName());
    }

    @Test
    void testRegisterDuplicateRideThrowsException() {
        rideManager.registerRide("ride1", "Roller Coaster");
        assertThrows(IllegalArgumentException.class, () -> rideManager.registerRide("ride1", "Ferris Wheel"));
    }

    @Test
    void testGetRide() {
        rideManager.registerRide("ride1", "Roller Coaster");
        Ride ride = rideManager.getRide("ride1");
        assertNotNull(ride);
        assertEquals("Roller Coaster", ride.getName());
    }

    @Test
    void testGetNonExistentRide() {
        assertNull(rideManager.getRide("nonexistent"));
    }

    @Test
    void testRemoveRide() {
        rideManager.registerRide("ride1", "Roller Coaster");
        Ride removedRide = rideManager.removeRide("ride1");
        assertNotNull(removedRide);
        assertEquals("ride1", removedRide.getId());
        assertNull(rideManager.getRide("ride1"));
    }

    @Test
    void testRemoveNonExistentRide() {
        assertNull(rideManager.removeRide("nonexistent"));
    }

    @Test
    void testEvaluateRideLogicGate() {
        Ride ride = rideManager.registerRide("ride1", "Roller Coaster");
        LogicGate mockGate = mock(LogicGate.class);
        when(mockGate.evaluate(true, false)).thenReturn(true);

        ride.addLogicGate(mockGate);
        boolean result = rideManager.evaluateRideLogicGate("ride1", 0, true, false);

        assertTrue(result);
        verify(mockGate).evaluate(true, false);
    }

    @Test
    void testEvaluateLogicGateWithInvalidRideId() {
        assertThrows(IllegalArgumentException.class, () -> rideManager.evaluateRideLogicGate("invalid", 0, true, false));
    }

    @Test
    void testEvaluateLogicGateWithInvalidIndex() {
        Ride ride = rideManager.registerRide("ride1", "Roller Coaster");
        assertThrows(IndexOutOfBoundsException.class, () -> rideManager.evaluateRideLogicGate("ride1", 0, true, false));
    }
}