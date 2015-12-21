package slava.cd.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimerImplTest {

	@Test
	public void testFinish() {
		long start = 10;
		TimerImpl timer = new TimerImpl();
		timer.setStart(start);
		
		assertTrue(timer.finish() > 0);
	}

}
