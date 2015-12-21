package slava.cd.steps;

import org.springframework.beans.factory.annotation.Autowired;

import slava.cd.command.Command;
import slava.cd.command.CommandFactory;
import slava.cd.pipeline.Step;
import slava.cd.util.OSChecker;

public class MvnInstallStep implements Step {
	
	private String projectDir;
	private CommandFactory commandFactory;
	private OSChecker osChecker;
	
	@Autowired
	public void setOsChecker(OSChecker osChecker) {
		this.osChecker = osChecker;
	}

	@Autowired
	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	public void setProjectDir(String projectDir) {
		this.projectDir = projectDir;
	}

	@Override
	public void run() {
		Command command = commandFactory.build((osChecker.isWindows() ? "cmd.exe /C " : "") + "mvn install");
		command.setWorkingDirectory(projectDir);
		command.run();
	}

	@Override
	public String getName() {
		return "mvn install in " + projectDir;
	}

}
