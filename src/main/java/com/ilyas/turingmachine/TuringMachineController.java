package com.ilyas.turingmachine;

import java.util.Map;

import com.ilyas.turingmachine.TM.AdditionTMProperties;
import com.ilyas.turingmachine.TM.PowerTMProperties;
import com.ilyas.turingmachine.TM.TuringMachine;
import com.ilyas.turingmachine.TM.TuringMachineProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class TuringMachineController {

    @Autowired
    AdditionTMProperties additionTMProperties;
    @Autowired
    PowerTMProperties powerTMProperties;

    @GetMapping
    public String testing() throws InterruptedException {
        return "turing machine testing";
    }

    @GetMapping("/prop")
    public TuringMachineProperties getProp() throws InterruptedException {
        return powerTMProperties;
    }

    @GetMapping(value = "/addition", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getAdditionResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(additionTMProperties, inputs);
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }

    @GetMapping(value = "/power", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getPowerResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(powerTMProperties, inputs);
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }
}
