package slava.cd.command;

import org.springframework.stereotype.Component;

@Component
public class CommandFactoryImpl implements CommandFactory {

	@Override
	public Command build(String command) {
		CommandImpl rtrn = new CommandImpl();
		rtrn.setLine(command);
		return rtrn;
	}

}
