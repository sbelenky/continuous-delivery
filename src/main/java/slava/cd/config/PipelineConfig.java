package slava.cd.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import slava.cd.pipeline.Pipeline;
import slava.cd.pipeline.PipelineImpl;
import slava.cd.pipeline.PipelinePackage;
import slava.cd.steps.GitCloneStep;

@Configuration
@ComponentScan(basePackageClasses=PipelinePackage.class)
public class PipelineConfig {

	@Bean
	public Pipeline pipeline(GitCloneStep gitCloneStep) {
		PipelineImpl rtrn = new PipelineImpl();
		
		gitCloneStep.setRepo("https://github.com/sbelenky/agg-updater.git");
		
		rtrn.setSteps(Arrays.asList(gitCloneStep));
		
		return rtrn;
	}
	
}
