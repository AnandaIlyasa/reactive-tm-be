package com.ilyas.turingmachine.TM;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "multiplication")
@PropertySource(value = "classpath:multiplication.yaml", factory = YamlPropertySourceFactory.class)
public class MultiplicationTMProperties extends TuringMachineProperties {

}
