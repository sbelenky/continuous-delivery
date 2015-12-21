package slava.cd.pipeline;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.slf4j.Logger;

import slava.cd.util.Timer;
import slava.cd.util.TimerFactory;

public class StepRunnerImplTest {

	@Test
	public void testRun() {
		String stepName = "Some name";
		Step step = mock(Step.class);
		when(step.getName()).thenReturn(stepName);
		
		Timer timer = mock(Timer.class);
		Integer seconds = 4;
		when(timer.finish()).thenReturn(seconds);
		
		TimerFactory timerFactory = mock(TimerFactory.class);
		when(timerFactory.startTimer()).thenReturn(timer);
		
		Logger logger = mock(Logger.class);
		
		StepRunnerImpl stepRunner = new StepRunnerImpl();
		stepRunner.setLogger(logger);
		stepRunner.setTimerFactory(timerFactory);
		
		stepRunner.run(step);
		
		verify(logger).info("Begin running step: " + stepName);
		verify(step).run();
		verify(logger).info("Finish running step (" + seconds + " seconds): " + stepName);
	}

}
