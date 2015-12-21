package slava.cd.pipeline;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import slava.cd.util.Timer;
import slava.cd.util.TimerFactory;

public class PipelineImpl implements Pipeline {
	
	private Logger logger = LoggerFactory.getLogger(PipelineImpl.class);
	private List<Step> steps;
	private StepRunner stepRunner;
	private TimerFactory timerFactory;
	
	@Autowired
	public void setTimerFactory(TimerFactory timerFactory) {
		this.timerFactory = timerFactory;
	}

	@Autowired
	public void setStepRunner(StepRunner stepRunner) {
		this.stepRunner = stepRunner;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public void run() {
		if (steps == null || steps.isEmpty()) {
			logger.warn("There are no steps");
			return;
		}
		
		Timer timer = timerFactory.startTimer();
		logger.info("Begin running pipeline");
		
		for (Step step : steps) {
			stepRunner.run(step);
		}
		
		logger.info("Finish running pipeline (" + timer.finish() + " seconds)");
	}

}
