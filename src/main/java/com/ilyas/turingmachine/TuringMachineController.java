package com.ilyas.turingmachine;

import java.util.Map;

import com.ilyas.turingmachine.TM.AdditionTMProperties;
import com.ilyas.turingmachine.TM.LogarithmTMProperties;
import com.ilyas.turingmachine.TM.ModuloTMProperties;
import com.ilyas.turingmachine.TM.MultiplicationTMProperties;
import com.ilyas.turingmachine.TM.PowerTMProperties;
import com.ilyas.turingmachine.TM.TuringMachine;
import com.ilyas.turingmachine.TM.TuringMachineProperties;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class TuringMachineController {

    private AdditionTMProperties additionTMProperties;
    private LogarithmTMProperties logarithmTMProperties;
    private ModuloTMProperties moduloTMProperties;
    private MultiplicationTMProperties multiplicationTMProperties;
    private PowerTMProperties powerTMProperties;

    public TuringMachineController(AdditionTMProperties additionTMProperties,
            LogarithmTMProperties logarithmTMProperties, ModuloTMProperties moduloTMProperties,
            MultiplicationTMProperties multiplicationTMProperties, PowerTMProperties powerTMProperties) {
        this.additionTMProperties = additionTMProperties;
        this.logarithmTMProperties = logarithmTMProperties;
        this.moduloTMProperties = moduloTMProperties;
        this.multiplicationTMProperties = multiplicationTMProperties;
        this.powerTMProperties = powerTMProperties;
    }

    @GetMapping
    public String testing() throws InterruptedException {
        return "turing machine testing";
    }

    @GetMapping("/prop")
    public TuringMachineProperties getProp() throws InterruptedException {
        return additionTMProperties;
    }

    @GetMapping(value = "/addition", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getAdditionResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(additionTMProperties, inputs);
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }

    @GetMapping(value = "/modulo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getModuloResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(moduloTMProperties, inputs);
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }

    @GetMapping(value = "/logarithm", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getLogarithmResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(logarithmTMProperties, inputs);
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }

    @GetMapping(value = "/multiplication", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getMultiplicationResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(multiplicationTMProperties, inputs);
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }

    @GetMapping(value = "/power", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, String>> getPowerResult(@RequestParam("inputs") String inputs) {
        TuringMachine additionTM = new TuringMachine(powerTMProperties, inputs);
        return Flux.create(emitter -> additionTM.run(emitter, inputs));
    }
}
