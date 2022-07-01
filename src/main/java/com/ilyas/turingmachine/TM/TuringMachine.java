package com.ilyas.turingmachine.TM;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import reactor.core.publisher.FluxSink;

public class TuringMachine {

    private TuringMachineProperties properties;

    private Integer head;
    // tape = index, symbol
    private Map<Integer, String> tape;
    private Boolean halted;
    private String current_state;

    {
        head = 0;
        tape = new TreeMap<Integer, String>();
        // current_state = this.initial_state;
        halted = false;
    }

    public TuringMachine(TuringMachineProperties properties, String userInpuString, String initialState) {
        this.properties = properties;
        this.current_state = initialState;
        IntStream.range(0, userInpuString.length()).forEach(i -> this.tape.put(i, userInpuString.substring(i, i + 1)));
    }

    public void run(FluxSink<Map<Integer, String>> emitter, String inputs) {
        Boolean checkIfHalted = isHaltedCorrectly();
        while (!this.halted && !checkIfHalted) {
            emitter.next(tape);
            try {
                step();
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            checkIfHalted = isHaltedCorrectly();
        }
        emitter.complete();
    }

    public void step() throws Exception {
        if (this.halted) {
            throw new Exception("Machine is halted");
        }
        // transition ex : q0_0 -> q0_0_1
        String currTransition_Key = this.current_state + "_" + this.tape.get(head);
        String currTransition_Value = this.properties.getTransitions().get(currTransition_Key);

        if (currTransition_Value == null) {
            this.halted = true;
            return;
        }

        String[] currTransition_Value_arr = currTransition_Value.split("_");
        String nextState = currTransition_Value_arr[0];
        String nextSymbol = currTransition_Value_arr[1];
        String direction = currTransition_Value_arr[2];

        this.tape.put(this.head, nextSymbol);
        this.current_state = nextState;
        this.head += Integer.parseInt(direction);
        this.tape.putIfAbsent(this.head, this.properties.getBlank_symbol());
    }

    public Boolean isHaltedCorrectly() {
        this.halted = this.properties.getAccepting_states().contains(this.current_state);
        return this.halted;
    }

    public String getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(String current_state) {
        this.current_state = current_state;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Map<Integer, String> getTape() {
        return tape;
    }

    public Boolean getHalted() {
        return halted;
    }

    public void setHalted(Boolean halted) {
        this.halted = halted;
    }
}
