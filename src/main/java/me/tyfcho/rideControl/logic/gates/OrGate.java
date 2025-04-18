package me.tyfcho.rideControl.logic.gates;

import me.tyfcho.rideControl.logic.LogicGate;

/**
 * Represents an OR logic gate.
 */
public class OrGate implements LogicGate {
    @Override
    public boolean evaluate(boolean... inputs) {
        if (inputs.length < 2) {
            throw new IllegalArgumentException("OR gate requires at least 2 inputs.");
        }
        for (boolean input : inputs) {
            if (input) {
                return true;
            }
        }
        return false;
    }
}