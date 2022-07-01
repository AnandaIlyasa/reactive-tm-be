package com.ilyas.turingmachine.TM;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "logarithm")
@PropertySource(value = "classpath:logarithm.yaml", factory = YamlPropertySourceFactory.class)
public class LogarithmTMProperties extends TuringMachineProperties {

}
