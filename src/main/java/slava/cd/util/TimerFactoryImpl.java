package slava.cd.util;

import org.springframework.stereotype.Component;

@Component
public class TimerFactoryImpl implements TimerFactory {

	@Override
	public Timer startTimer() {
		TimerImpl timer = new TimerImpl();
		timer.setStart(System.currentTimeMillis());
		return timer;
	}

}
