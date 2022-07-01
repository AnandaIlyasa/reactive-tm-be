package com.ilyas.turingmachine.TM;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "modulo")
@PropertySource(value = "classpath:modulo.yaml", factory = YamlPropertySourceFactory.class)
public class ModuloTMProperties extends TuringMachineProperties {

}
