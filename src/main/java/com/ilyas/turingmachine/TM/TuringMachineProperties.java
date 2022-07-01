package com.ilyas.turingmachine.TM;

import java.util.Map;
import java.util.Set;

public class TuringMachineProperties {
    // Constant properties provided from yaml files
    private String name;
    private Set<String> states;
    // private Set<String> symbols;
    // input_symbols format : 3 + 2 -> 000c00 , -2 + -3 -> 11c111
    // 0 for positive and 1 for negative
    // private Set<String> input_symbols;
    private Set<String> accepting_states;
    private Map<String, String> transitions;
    // currState_currSymbol -> newState_newSymbol_direction
    private String blank_symbol;
    private String initial_state;

    public String getInitial_state() {
        return initial_state;
    }

    public void setInitial_state(String initial_state) {
        this.initial_state = initial_state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getStates() {
        return states;
    }

    public void setStates(Set<String> states) {
        this.states = states;
    }

    public Set<String> getAccepting_states() {
        return accepting_states;
    }

    public void setAccepting_states(Set<String> accepting_states) {
        this.accepting_states = accepting_states;
    }

    public Map<String, String> getTransitions() {
        return transitions;
    }

    public void setTransitions(Map<String, String> transitions) {
        this.transitions = transitions;
    }

    public String getBlank_symbol() {
        return blank_symbol;
    }

    public void setBlank_symbol(String blank_symbol) {
        this.blank_symbol = blank_symbol;
    }

}
