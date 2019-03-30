package turingparser.commands;

import java.util.ArrayList;

import turingparser.GlobalMachine;

public class CommandRightUntil extends Command
{

	private ArrayList<Character> symbols;
	private boolean not;

	public CommandRightUntil(ArrayList<Character> symbols, boolean not)
	{
		this.symbols = symbols;
		this.not=not;
	}

	@Override
	public void execute()
	{
		if(not)
		{
			GlobalMachine.getGlobalMachine().moveRightUntilNot(symbols);
		}
		else
		{
			GlobalMachine.getGlobalMachine().moveRightUntil(symbols);
		}
		
		print();
	}

}
