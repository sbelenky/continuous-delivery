package slava.cd.util;

public class TimerImpl implements Timer {
	
	private long start;
	
	public void setStart(long start) {
		this.start = start;
	}

	@Override
	public int finish() {
		return Math.toIntExact((System.currentTimeMillis() - start) / 1000);
	}

}
