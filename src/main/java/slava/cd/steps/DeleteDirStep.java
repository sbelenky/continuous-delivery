package slava.cd.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import slava.cd.CDException;
import slava.cd.pipeline.Step;

public class DeleteDirStep implements Step {
	
	private String dir;
	
	public void setDir(String dir) {
		this.dir = dir;
	}

	@Override
	public void run() {
		try {
			FileUtils.deleteDirectory(new File(dir));
		} catch (IOException e) {
			throw new CDException(e);
		}
	}

	@Override
	public String getName() {
		return "Delete dir " + dir;
	}

}
