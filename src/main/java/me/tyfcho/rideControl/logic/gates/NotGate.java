package me.tyfcho.rideControl.logic.gates;

import me.tyfcho.rideControl.logic.LogicGate;

/**
 * Represents a NOT logic gate.
 */
public class NotGate implements LogicGate {
    @Override
    public boolean evaluate(boolean... inputs) {
        if (inputs.length != 1) {
            throw new IllegalArgumentException("NOT gate requires exactly 1 input.");
        }
        return !inputs[0];
    }
}