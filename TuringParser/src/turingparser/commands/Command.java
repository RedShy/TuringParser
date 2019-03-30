package turingparser.commands;

import turingparser.GlobalMachine;

public abstract class Command
{
	public abstract void execute();
	
	public void print()
	{
		GlobalMachine.getGlobalMachine().print();
	}

}
