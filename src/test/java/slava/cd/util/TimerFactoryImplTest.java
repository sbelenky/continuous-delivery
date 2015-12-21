package slava.cd.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimerFactoryImplTest {

	@Test
	public void testStartTimer() {
		TimerFactoryImpl timerFactory = new TimerFactoryImpl();
		assertNotNull(timerFactory.startTimer());
	}

}
