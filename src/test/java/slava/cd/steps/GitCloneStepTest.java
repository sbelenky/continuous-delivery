package slava.cd.steps;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import slava.cd.command.Command;
import slava.cd.command.CommandFactory;
import slava.cd.steps.GitCloneStep;

public class GitCloneStepTest {
	
	private static final String someRepo = "https://github.com/sbelenky/agg-updater.git";
	
	private GitCloneStep gitCloneStep;
	
	@Before
	public void setUp() {
		gitCloneStep = new GitCloneStep();
		gitCloneStep.setRepo(someRepo);
	}

	@Test
	public void testRun() {
		CommandFactory commandFactory = mock(CommandFactory.class);
		Command command = mock(Command.class);
		
		when(commandFactory.build("git clone " + someRepo)).thenReturn(command);
		
		gitCloneStep.setCommandFactory(commandFactory);
		gitCloneStep.run();
		
		verify(command).run();
	}

	@Test
	public void testGetName() {
		assertThat(gitCloneStep.getName(), is("git clone " + someRepo));
	}

}
