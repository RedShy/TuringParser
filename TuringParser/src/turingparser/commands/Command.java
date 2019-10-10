package turingparser.commands;

import turingparser.GlobalMachine;
import turingparser.OutOfTapeException;

public abstract class Command
{
	public abstract void execute() throws OutOfTapeException;
	
	public void print()
	{
		GlobalMachine.getGlobalMachine().print();
	}

}
