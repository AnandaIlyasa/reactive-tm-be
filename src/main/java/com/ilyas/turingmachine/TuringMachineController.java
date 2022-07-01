package com.ilyas.turingmachine;

import java.util.Map;

import com.ilyas.turingmachine.TM.AdditionTMProperties;
import com.ilyas.turingmachine.TM.TuringMachine;

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

    @GetMapping
    public String testing() throws InterruptedException {
        return "turing machine testing";
    }

    @GetMapping("/prop")
    public TuringMachine getProp() throws InterruptedException {
        return new TuringMachine(additionTMProperties, "/prop endpoint", additionTMProperties.getInitial_state());
    }

    @GetMapping(value = "/addition", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getAdditionResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(additionTMProperties, inputs,
                additionTMProperties.getInitial_state());
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }
}
