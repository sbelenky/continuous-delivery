package slava.cd.pipeline;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import slava.cd.util.Timer;
import slava.cd.util.TimerFactory;

public class PipelineImplTest {
	
	private PipelineImpl pipeline;
	private Logger logger;
	
	@Before
	public void setUp() {
		pipeline = new PipelineImpl();
		logger = mock(Logger.class);
		pipeline.setLogger(logger);
	}

	@Test
	public void testRun_stepsNull() {
		pipeline.run();
		verify(logger).warn("There are no steps");
	}
	
	@Test
	public void testRun_stepsEmpty() {
		List<Step> steps = new ArrayList<>();
		pipeline.setSteps(steps);
		pipeline.run();
		verify(logger).warn("There are no steps");
	}
	
	@Test
	public void testRun_oneStep() {
		Step step = mock(Step.class);

		List<Step> steps = new ArrayList<>();
		steps.add(step);
		
		Timer timer = mock(Timer.class);
		Integer seconds = 4;
		when(timer.finish()).thenReturn(seconds);

		StepRunner stepRunner = mock(StepRunner.class);
		
		TimerFactory timerFactory = mock(TimerFactory.class);
		when(timerFactory.startTimer()).thenReturn(timer);
		
		pipeline.setSteps(steps);
		pipeline.setStepRunner(stepRunner);
		pipeline.setTimerFactory(timerFactory);
		
		pipeline.run();
		
		verify(logger).info("Begin running pipeline");
		verify(stepRunner).run(step);
		verify(logger).info("Finish running pipeline (" + seconds + " seconds)");
	}

	@Test
	public void testRun_multipleSteps() {
		Step step1 = mock(Step.class);
		Step step2 = mock(Step.class);
		Step step3 = mock(Step.class);
		
		List<Step> steps = new ArrayList<>();
		steps.add(step1);
		steps.add(step2);
		steps.add(step3);
		
		Timer timer = mock(Timer.class);
		Integer seconds = 12;
		when(timer.finish()).thenReturn(seconds);
		
		StepRunner stepRunner = mock(StepRunner.class);
		
		TimerFactory timerFactory = mock(TimerFactory.class);
		when(timerFactory.startTimer()).thenReturn(timer);
		
		pipeline.setSteps(steps);
		pipeline.setStepRunner(stepRunner);
		pipeline.setTimerFactory(timerFactory);
		
		pipeline.run();
		
		verify(logger).info("Begin running pipeline");
		verify(stepRunner).run(step1);
		verify(stepRunner).run(step2);
		verify(stepRunner).run(step3);
		verify(logger).info("Finish running pipeline (" + seconds + " seconds)");
	}
	
}
