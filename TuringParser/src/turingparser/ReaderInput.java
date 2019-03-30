package turingparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderInput
{
	public ArrayList<Sequence> readInput(String path) throws FileNotFoundException
	{
		ArrayList<Sequence> sequences = new ArrayList<>();
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
				sequences.add(new Sequence(line));
			}
			nLine++;
		}
		in.close();
		return sequences;
	}
}
