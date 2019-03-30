package turingparser.commands;

import turingparser.GlobalMachine;

public class CommandStoreVariable extends Command
{
	private char variable;
	
	public CommandStoreVariable(char variable)
	{
		super();
		this.variable = variable;
	}


	@Override
	public void execute()
	{
		GlobalMachine.getGlobalMachine().store(variable);
	}

}
