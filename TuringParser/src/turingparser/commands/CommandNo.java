package turingparser.commands;

import turingparser.EndStateMachine;
import turingparser.GlobalMachine;

public class CommandNo extends Command
{
	@Override
	public void execute()
	{
		GlobalMachine.getGlobalMachine().setState(EndStateMachine.NO);
		
		print();
	}
}
