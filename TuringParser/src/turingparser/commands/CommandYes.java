package turingparser.commands;

import turingparser.EndStateMachine;
import turingparser.GlobalMachine;

public class CommandYes extends Command
{

	@Override
	public void execute()
	{
		GlobalMachine.getGlobalMachine().setState(EndStateMachine.YES);
		
		print();
	}

}
