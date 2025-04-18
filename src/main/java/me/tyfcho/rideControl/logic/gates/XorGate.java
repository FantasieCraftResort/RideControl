package me.tyfcho.rideControl.logic.gates;

import me.tyfcho.rideControl.logic.LogicGate;

/**
 * Represents an XOR logic gate.
 */
public class XorGate implements LogicGate {
    @Override
    public boolean evaluate(boolean... inputs) {
        if (inputs.length < 2) {
            throw new IllegalArgumentException("XOR gate requires at least 2 inputs.");
        }
        boolean result = false;
        for (boolean input : inputs) {
            result ^= input; // XOR operation
        }
        return result;
    }
}