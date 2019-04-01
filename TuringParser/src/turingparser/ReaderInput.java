package turingparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
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
}
