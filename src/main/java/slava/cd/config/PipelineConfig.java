package slava.cd.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import slava.cd.pipeline.Pipeline;
import slava.cd.pipeline.PipelineImpl;
import slava.cd.pipeline.PipelinePackage;
import slava.cd.pipeline.Step;
import slava.cd.steps.DeleteDirStep;
import slava.cd.steps.GitCloneStep;
import slava.cd.steps.MvnInstallStep;

@Configuration
@ComponentScan(basePackageClasses=PipelinePackage.class)
public class PipelineConfig {
	
	private static final String PROJECT = "agg-updater";

	@Bean
	public Pipeline pipeline() {
		List<Step> steps = new ArrayList<>();
		
		steps.add(deleteProjectDir());
		steps.add(gitClone());
		steps.add(mvnInstall());
		
		PipelineImpl rtrn = new PipelineImpl();
		rtrn.setSteps(steps);
		return rtrn;
	}
	
	@Bean
	public Step deleteProjectDir() {
		DeleteDirStep rtrn = new DeleteDirStep();
		rtrn.setDir(PROJECT);
		return rtrn;
	}
	
	@Bean
	public Step gitClone() {
		GitCloneStep rtrn = new GitCloneStep();
		rtrn.setRepo("https://github.com/sbelenky/" + PROJECT + ".git");
		return rtrn;
	}
	
	@Bean
	public Step mvnInstall() {
		MvnInstallStep rtrn = new MvnInstallStep();
		rtrn.setProjectDir(PROJECT);
		return rtrn;
	}
}
