package turingparser.commands;

import turingparser.GlobalMachine;

public class CommandLeft extends Command
{

	@Override
	public void execute()
	{
		GlobalMachine.getGlobalMachine().moveLeft();
		
		print();
	}

}
