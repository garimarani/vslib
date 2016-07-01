package org.vsfamily.vslib.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/applicationContext-security.xml")
public class InfrastructureContextConfiguration {

}
