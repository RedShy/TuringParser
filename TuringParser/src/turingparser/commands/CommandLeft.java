package turingparser.commands;

import turingparser.GlobalMachine;
import turingparser.OutOfTapeException;

public class CommandLeft extends Command
{

	@Override
	public void execute() throws OutOfTapeException
	{
		GlobalMachine.getGlobalMachine().moveLeft();
		
		print();
	}

}
