package turingparser.commands;

import turingparser.GlobalMachine;
import turingparser.OutOfTapeException;

public class CommandRight extends Command
{

	@Override
	public void execute() throws OutOfTapeException
	{
		GlobalMachine.getGlobalMachine().moveRight();
		
		print();
	}

}
