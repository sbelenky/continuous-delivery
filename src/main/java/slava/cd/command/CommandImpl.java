package slava.cd.command;

import java.io.File;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import slava.cd.CDException;

public class CommandImpl implements Command {
	
	private String line;
	private String workingDirectory;
	
	public void setLine(String line) {
		this.line = line;
	}
	
	@Override
	public void setWorkingDirectory(String workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	@Override
	public void run() {
		CommandLine cmdLine = CommandLine.parse(line);
		DefaultExecutor executor = new DefaultExecutor();
		
		if (workingDirectory != null) {
			executor.setWorkingDirectory(new File(workingDirectory));
		}
		
		try {
			executor.execute(cmdLine);
		} catch (Exception e) {
			throw new CDException(e);
		}
	}

}
