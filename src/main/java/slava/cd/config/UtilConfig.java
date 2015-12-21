package slava.cd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import slava.cd.util.UtilPackage;

@Configuration
@ComponentScan(basePackageClasses=UtilPackage.class)
public class UtilConfig {

}
