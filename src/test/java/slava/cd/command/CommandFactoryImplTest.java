package slava.cd.command;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandFactoryImplTest {

	@Test
	public void testBuild() {
		CommandFactoryImpl commandFactory = new CommandFactoryImpl();
		assertNotNull(commandFactory.build("some command"));
	}

}
