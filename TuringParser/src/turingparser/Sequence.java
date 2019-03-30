package turingparser;

import java.util.ArrayList;

import turingparser.commands.Command;
import turingparser.commands.CommandHalt;
import turingparser.commands.CommandLeft;
import turingparser.commands.CommandLeftUntil;
import turingparser.commands.CommandNo;
import turingparser.commands.CommandRight;
import turingparser.commands.CommandRightUntil;
import turingparser.commands.CommandStoreVariable;
import turingparser.commands.CommandWrite;
import turingparser.commands.CommandYes;

public class Sequence
{
	private ArrayList<Command> commands = new ArrayList<>();
	private ArrayList<Chooser> choosers = new ArrayList<>();

	public Sequence(String sequence)
	{
		String[] parts = sequence.split(":");
		
		if(parts.length<2)
			return;
		createCommands(parts[1]);
		
		if(parts.length<3)
			return;
		createChoosers(parts[2]);
	}

	private void createCommands(String string)
	{
		String[] cmds = string.split(" ");
		
		if(cmds.length == 0)
			return;

		for (int i = 0; i < cmds.length; i++)
		{
			if (cmds[i].length() == 1)
			{
				switch (cmds[i].charAt(0))
				{
				case 'R':
					commands.add(new CommandRight());
					break;
				case 'L':
					commands.add(new CommandLeft());
					break;
				case 'y':
					commands.add(new CommandYes());
					break;
				case 'n':
					commands.add(new CommandNo());
					break;
				case 'h':
					commands.add(new CommandHalt());
					break;
				case 'X':
					commands.add(new CommandStoreVariable('x'));
					break;
				case 'W':
					commands.add(new CommandStoreVariable('w'));
					break;
				default:
					commands.add(new CommandWrite(cmds[i].charAt(0)));
				}
			} else
			{
				String[] until = cmds[i].split("_");

				String[] symbols = until[1].split(",");
				boolean not = false;
				ArrayList<Character> sy = new ArrayList<>();
				for(int j=0; j<symbols.length; j++)
				{
					if(symbols[j].charAt(0) == 'n')
					{
						not=true;
					}
					else
					{
						sy.add(symbols[j].charAt(0));
					}
				}

				switch (until[0].charAt(0))
				{
				case 'R':
					commands.add(new CommandRightUntil(sy,not));
					break;
				case 'L':
					commands.add(new CommandLeftUntil(sy,not));
					break;
				}
			}

		}

	}

	private void createChoosers(String string)
	{
		String[] chsers = string.split(" ");
		
		if(chsers.length == 0)
			return;
		
		for(int i=0; i<chsers.length; i++)
		{
			String[] values = chsers[i].split("_");
		
			String[] symbols = values[0].split(",");
			boolean not = false;
			boolean always = false;
			boolean x=false;
			boolean w=false;
			ArrayList<Character> sy = new ArrayList<>();
			for(int j=0; j<symbols.length; j++)
			{
				if(symbols[j].charAt(0) == 'n')
				{
					not=true;
				}
				else if(symbols[j].charAt(0) == 'A')
				{
					always=true;
				}
				else if(symbols[j].charAt(0) == 'x')
				{
					x=true;
				}
				else if(symbols[j].charAt(0) == 'w')
				{
					w=true;
				}
				else
				{
					sy.add(symbols[j].charAt(0));
				}
			}
			
			choosers.add(new Chooser(sy,always,not,x,w,Integer.parseInt(values[1])));
		}
	}

	public int execute()
	{
		for (int i = 0; i < commands.size(); i++)
		{
			commands.get(i).execute();
		}

		int nextSequence = -1;
		for (int i = 0; i < choosers.size(); i++)
		{
			if (choosers.get(i).change())
			{
				nextSequence = choosers.get(i).nextSequence();
			}
		}
		return nextSequence;
	}

	@Override
	public String toString()
	{
		return "Sequence [commands=" + commands + ", choosers=" + choosers + "]";
	}

	
	
}
