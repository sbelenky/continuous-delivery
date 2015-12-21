package slava.cd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import slava.cd.config.CommandConfig;
import slava.cd.config.PipelineConfig;
import slava.cd.config.UtilConfig;
import slava.cd.pipeline.Pipeline;

public class Main {
	
    public static void main(String[] args) {
    	@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				UtilConfig.class, PipelineConfig.class, CommandConfig.class);
    	ctx.registerShutdownHook();
    	
    	Pipeline pipeline = ctx.getBean(Pipeline.class);
        pipeline.run();
    }
}
