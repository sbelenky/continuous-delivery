package slava.cd.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slava.cd.command.Command;
import slava.cd.command.CommandFactory;
import slava.cd.pipeline.Step;

@Component
public class GitCloneStep implements Step {
	
	private String repo;
	private CommandFactory commandFactory;
	
	public void setRepo(String repo) {
		this.repo = repo;
	}

	@Autowired
	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	@Override
	public void run() {
		Command command = commandFactory.build("git clone " + repo);
		command.run();
	}

	@Override
	public String getName() {
		return "git clone " + repo;
	}

}
