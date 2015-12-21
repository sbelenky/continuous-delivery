package slava.cd.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import slava.cd.command.Command;
import slava.cd.command.CommandFactory;
import slava.cd.util.OSChecker;

public class MvnInstallStepTest {
	
	private static final String PROJECT_DIR = "project-dir";
	private MvnInstallStep mvnInstallStep;
	private OSChecker osChecker;
	private CommandFactory commandFactory;
	private Command command;
	
	@Before
	public void setUp() {
		osChecker = mock(OSChecker.class);
		commandFactory = mock(CommandFactory.class);
		command = mock(Command.class);
		
		mvnInstallStep = new MvnInstallStep();
		mvnInstallStep.setProjectDir(PROJECT_DIR);
		mvnInstallStep.setOsChecker(osChecker);
		mvnInstallStep.setCommandFactory(commandFactory);
	}

	@Test
	public void testRun_nonWindows() {
		when(osChecker.isWindows()).thenReturn(false);
		when(commandFactory.build("mvn install")).thenReturn(command);
		
		mvnInstallStep.run();
		
		verify(command).setWorkingDirectory(PROJECT_DIR);
		verify(command).run();
	}
	
	@Test
	public void testRun_windows() {
		when(osChecker.isWindows()).thenReturn(true);
		when(commandFactory.build("cmd.exe /C mvn install")).thenReturn(command);
		
		mvnInstallStep.run();
		
		verify(command).setWorkingDirectory(PROJECT_DIR);
		verify(command).run();
	}

	@Test
	public void testGetName() {
		assertThat(mvnInstallStep.getName(), is("mvn install in " + PROJECT_DIR));
	}

}
