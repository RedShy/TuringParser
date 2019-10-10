package turingparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TuringParser
{

	public static void main(String[] args) throws IOException
	{
		Machine m = new Machine();
		
		ReaderInput ri = new ReaderInput();
		
		m.setSequenceCommands(ri.readInput("./machine.txt"));
		
	    if(args.length > 0)
	    {
	    	if(args[0].equals("-t"))
	    	{
	    		launchTests(m, ri);
	    	}
	    	else
	    	{
	    		System.err.println("Usare -t per lanciare i test o niente per eseguire solo la stringa in input");
	    	}
	    }
	    else
	    {
			GlobalMachine.getGlobalMachine().print();
			m.execute();
	    }
	}

	private static void launchTests(Machine m, ReaderInput ri) throws FileNotFoundException
	{
		boolean goodRun=true;
		List<TestInput> tests=ri.readTests("./tests.txt");
		for(TestInput t: tests)
		{
			System.out.println("------ ESEGUO TEST CON STRINGA: "+t.input+" ------");
			GlobalMachine.getGlobalMachine().setInput(t.input.toCharArray());
			GlobalMachine.getGlobalMachine().print();
			m.execute();
			
			if(t.resultState == EndStateMachine.HALT)
			{
				if(!String.valueOf(GlobalMachine.getGlobalMachine().getTape()).equals(t.output))
				{
					System.out.println("TEST FALLITO CON LA STRINGA: "+t.input);
					System.out.println("OUTPUT RICHIESTO: "+t.output);
					System.out.println("OUTPUT FORNITO: "+ String.valueOf(GlobalMachine.getGlobalMachine().getTape()));				
					goodRun = false;
					break;
				}
			}
			else
			{
				if(GlobalMachine.getGlobalMachine().getState() != t.resultState)
				{
					System.out.println("TEST FALLITO CON LA STRINGA: "+t.input);
					System.out.println("STATO RICHIESTO: "+t.resultState);
					System.out.println("STATO FORNITO: "+GlobalMachine.getGlobalMachine().getState());
					goodRun=false;
					break;
				}
			}
		}
		
		if(goodRun)
		{
			System.out.println("TUTTI I TEST SONO OKAY!");
		}
	}

}
