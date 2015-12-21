package slava.cd.steps;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class DeleteDirStepTest {
	
	@Test
	public void testGetName() {
		String dir = "some-dir";
		
		DeleteDirStep deleteDirStep = new DeleteDirStep();
		deleteDirStep.setDir(dir);
		
		assertThat(deleteDirStep.getName(), is("Delete dir " + dir));
	}

}
