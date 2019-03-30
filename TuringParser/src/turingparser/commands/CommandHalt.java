package turingparser.commands;

import turingparser.EndStateMachine;
import turingparser.GlobalMachine;

public class CommandHalt extends Command
{

	@Override
	public void execute()
	{
		GlobalMachine.getGlobalMachine().setState(EndStateMachine.HALT);
		
		print();
	}

}
