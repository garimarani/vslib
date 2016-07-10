package org.vsfamily.vslib.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Context configuration class for calling external .xml files.
 */
@Configuration
@ImportResource("classpath:/applicationContext-security.xml")
public class InfrastructureContextConfiguration {

}
