package me.tyfcho.rideControl.logic.gates;

import me.tyfcho.rideControl.logic.LogicGate;

/**
 * Represents an XNOR logic gate.
 */
public class XnorGate implements LogicGate {
    @Override
    public boolean evaluate(boolean... inputs) {
        if (inputs.length < 2) {
            throw new IllegalArgumentException("XNOR gate requires at least 2 inputs.");
        }
        boolean result = true;
        for (boolean input : inputs) {
            result ^= input; // XOR operation
        }
        return !result; // Negate the XOR result
    }
}