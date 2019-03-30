package turingparser.commands;

import java.util.ArrayList;

import turingparser.GlobalMachine;

public class CommandLeftUntil extends Command
{
	private ArrayList<Character> symbols;
	private boolean not;

	public CommandLeftUntil(ArrayList<Character> symbols, boolean not)
	{
		this.symbols = symbols;
		this.not=not;
	}

	@Override
	public void execute()
	{
		if(not)
		{
			GlobalMachine.getGlobalMachine().moveLeftUntilNot(symbols);
		}
		else
		{
			GlobalMachine.getGlobalMachine().moveLeftUntil(symbols);
		}
		
		print();
	}

}
