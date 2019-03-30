package turingparser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TuringParser
{

	public static void main(String[] args) throws IOException
	{
		Machine m = new Machine();
		
		ReaderInput ri = new ReaderInput();
		
		m.setSequenceCommands(ri.readInput("./machine.txt"));
		
		GlobalMachine.getGlobalMachine().print();
		
		m.execute();

	}

}
