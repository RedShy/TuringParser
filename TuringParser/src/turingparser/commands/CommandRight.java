package turingparser.commands;

import turingparser.GlobalMachine;

public class CommandRight extends Command
{

	@Override
	public void execute()
	{
		GlobalMachine.getGlobalMachine().moveRight();
		
		print();
	}

}
