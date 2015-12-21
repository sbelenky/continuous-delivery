package slava.cd.command;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import slava.cd.CDException;

public class CommandImpl implements Command {
	
	private String line;
	
	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public void run() {
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		
		try {
			executor.execute(cmdLine);
		} catch (Exception e) {
			throw new CDException(e);
		}
	}

}
