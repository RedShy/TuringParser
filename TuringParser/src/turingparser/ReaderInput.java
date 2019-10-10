package turingparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReaderInput
{
	public Map<Integer,Sequence> readInput(String path) throws FileNotFoundException
	{
		Map<Integer,Sequence> sequences = new HashMap<>();
		Scanner in = new Scanner(new FileReader(path));
		int nLine=0;
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			System.out.println(line);
			
			if(nLine==0)
			{
				GlobalMachine.getGlobalMachine().setInput(line.toCharArray());
			}
			else
			{
				String[] parts = line.split(":");
				
				sequences.put(Integer.parseInt(parts[0]), new Sequence(line));
			}
			nLine++;
		}
		in.close();
		return sequences;
	}

	public List<TestInput> readTests(String path) throws FileNotFoundException
	{
		List<TestInput> tests = new ArrayList<>();
		Scanner in = new Scanner(new FileReader(path));
		System.out.println("TESTS");
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			System.out.println(line);
			
			String[] parts = line.split(":");
			EndStateMachine state = EndStateMachine.HALT;
			switch(parts[1])
			{
				case "y":
					state = EndStateMachine.YES;
					break;
				case "n":
					state = EndStateMachine.NO;
					break;
			}
			
			String output = "";
			if(parts.length == 3)
				output = GlobalMachine.generateTapeWithString(parts[2]);
			else if(parts.length < 3 && state == EndStateMachine.HALT)
			{
				output = GlobalMachine.generateTapeWithString("");
			}
			
			tests.add(new TestInput(parts[0],state,output));
		}
		in.close();
		return tests;
	}
}
