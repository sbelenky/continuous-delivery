package slava.cd.command;

public interface Command {
	
	void run();

	void setWorkingDirectory(String workingDirectory);

}
