package turingparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Machine
{
	private String name;
	private Map<Integer,Sequence> sequenceCommands = new HashMap<>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public void setSequenceCommands(Map<Integer, Sequence> sequenceCommands)
	{
		this.sequenceCommands = sequenceCommands;
	}

	public void execute()
	{
		int nextSequence = 0;
		while (nextSequence != -1)
		{
			System.out.println("ESEGUO SEQUENZA: "+nextSequence);
			nextSequence = sequenceCommands.get(nextSequence).execute();
		}
	}

	@Override
	public String toString()
	{
		return "Machine [name=" + name + ", sequenceCommands=" + sequenceCommands + "]";
	}
	
	
}
