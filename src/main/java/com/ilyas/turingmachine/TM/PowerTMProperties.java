package com.ilyas.turingmachine.TM;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "power")
@PropertySource(value = "classpath:algorithms.yaml", factory = YamlPropertySourceFactory.class)
public class PowerTMProperties extends TuringMachineProperties {

}
