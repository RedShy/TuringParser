package turingparser.commands;

import turingparser.GlobalMachine;

public class CommandWrite extends Command
{
	private char symbol;
	
	public CommandWrite(char symbol)
	{
		this.symbol = symbol;
	}

	@Override
	public void execute()
	{
		GlobalMachine.getGlobalMachine().write(symbol);
		
		print();
	}

}
