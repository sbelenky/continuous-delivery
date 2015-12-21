package slava.cd.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slava.cd.util.Timer;
import slava.cd.util.TimerFactory;

@Component
public class StepRunnerImpl implements StepRunner {
	
	private Logger logger = LoggerFactory.getLogger(StepRunnerImpl.class);
	private TimerFactory timerFactory;
	
	@Autowired
	public void setTimerFactory(TimerFactory timerFactory) {
		this.timerFactory = timerFactory;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void run(Step step) {
		Timer timer = timerFactory.startTimer();
		logger.info("Begin running step: " + step.getName());
		step.run();
		logger.info("Finish running step (" + timer.finish() + " seconds): " + step.getName());
	}

}
