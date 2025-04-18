package me.tyfcho.rideControl.logic;

/**
 * Represents a logic gate that can evaluate boolean inputs.
 */
public interface LogicGate {
    /**
     * Evaluates the logic gate with the given inputs.
     *
     * @param inputs The boolean inputs for the logic gate.
     * @return The result of the logic gate evaluation.
     * @throws IllegalArgumentException If the number of inputs is invalid for the gate.
     */
    boolean evaluate(boolean... inputs);
}