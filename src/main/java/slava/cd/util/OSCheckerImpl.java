package slava.cd.util;

import org.springframework.stereotype.Component;

@Component
public class OSCheckerImpl implements OSChecker {

	@Override
	public boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("win");
	}

}
