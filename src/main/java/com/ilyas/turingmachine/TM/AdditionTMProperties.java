package com.ilyas.turingmachine.TM;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:addition.yaml", factory = YamlPropertySourceFactory.class)
public class AdditionTMProperties extends TuringMachineProperties {

}
