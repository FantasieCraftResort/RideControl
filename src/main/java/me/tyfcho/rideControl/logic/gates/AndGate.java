package me.tyfcho.rideControl.logic.gates;

import me.tyfcho.rideControl.logic.LogicGate;

/**
 * Represents an AND logic gate.
 */
public class AndGate implements LogicGate {
    @Override
    public boolean evaluate(boolean... inputs) {
        if (inputs.length < 2) {
            throw new IllegalArgumentException("AND gate requires at least 2 inputs.");
        }
        for (boolean input : inputs) {
            if (!input) {
                return false;
            }
        }
        return true;
    }
}