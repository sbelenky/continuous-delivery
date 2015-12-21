package slava.cd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import slava.cd.steps.StepsPackage;

@Configuration
@ComponentScan(basePackageClasses=StepsPackage.class)
public class StepsConfig {

}
