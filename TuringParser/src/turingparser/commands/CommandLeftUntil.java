package turingparser.commands;

import java.util.ArrayList;

import turingparser.GlobalMachine;
import turingparser.OutOfTapeException;

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
	public void execute() throws OutOfTapeException
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
