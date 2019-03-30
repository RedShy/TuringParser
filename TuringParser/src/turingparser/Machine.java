package turingparser;

import java.util.ArrayList;

public class Machine
{
	private String name;
	private ArrayList<Sequence> sequenceCommands = new ArrayList<>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Sequence> getSequenceCommands()
	{
		return sequenceCommands;
	}

	public void setSequenceCommands(ArrayList<Sequence> sequenceCommands)
	{
		this.sequenceCommands = sequenceCommands;
	}

	public void execute()
	{
		int nextSequence = 0;
		while (nextSequence != -1)
		{
			nextSequence = sequenceCommands.get(nextSequence).execute();
		}
	}

	@Override
	public String toString()
	{
		return "Machine [name=" + name + ", sequenceCommands=" + sequenceCommands + "]";
	}
	
	
}
