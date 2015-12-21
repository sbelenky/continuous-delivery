package slava.cd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import slava.cd.command.CommandPackage;

@Configuration
@ComponentScan(basePackageClasses=CommandPackage.class)
public class CommandConfig {

}
