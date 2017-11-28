package be.vdab.restservices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableEntityLinks;

@Configuration
@EnableEntityLinks
@ComponentScan
public class RestControllersConfig {
}
