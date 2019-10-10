package turingparser;

import java.util.ArrayList;

public class GlobalMachine
{
	public static final char BLANK = 'B';
	public static final int DEFAULT_SIZE = 30;

	private char[] tape;
	private int cursor;
	private EndStateMachine state = EndStateMachine.EXECUTING;

	private static GlobalMachine gb = null;

	private char x='_';
	private char w='_';

	public static GlobalMachine getGlobalMachine()
	{
		if (gb == null)
		{
			gb = new GlobalMachine();
		}
		return gb;
	}

	private GlobalMachine()
	{}



	public char[] getTape()
	{
		return tape;
	}

	public int getCursor()
	{
		return cursor;
	}

	public void setCursor(int cursor)
	{
		this.cursor = cursor;
	}

	public EndStateMachine getState()
	{
		return state;
	}

	public void setState(EndStateMachine state)
	{
		this.state = state;
	}

	public char getX()
	{
		return x;
	}

	public void setX(char x)
	{
		this.x = x;
	}

	public char getW()
	{
		return w;
	}

	public void setW(char w)
	{
		this.w = w;
	}

	public void write(char symbol)
	{
		switch (symbol)
		{
		case 'x':
			tape[cursor] = x;
			break;
		case 'w':
			tape[cursor] = w;
			break;
		default:
			tape[cursor] = symbol;
		}

	}

	public void moveRight()
	{
		cursor++;
	}

	public void moveRightUntil(ArrayList<Character> symbols)
	{
		boolean found = false;
		while (!found)
		{
			cursor++;
			for (int i = 0; i < symbols.size(); i++)
			{
				if (tape[cursor] == symbols.get(i))
				{
					found = true;
				}
			}
		}
	}

	public void moveRightUntilNot(ArrayList<Character> symbols)
	{
		boolean found = false;
		while (!found)
		{
			cursor++;
			for (int i = 0; i < symbols.size(); i++)
			{
				if (tape[cursor] != symbols.get(i))
				{
					found = true;
				}
			}
		}
	}

	public void moveLeft()
	{
		cursor--;
	}

	public void moveLeftUntil(ArrayList<Character> symbols)
	{
		boolean found = false;
		while (!found)
		{
			cursor--;
			for (int i = 0; i < symbols.size(); i++)
			{
				if (tape[cursor] == symbols.get(i))
				{
					found = true;
				}
			}
		}
	}

	public void moveLeftUntilNot(ArrayList<Character> symbols)
	{
		boolean found = false;
		while (!found)
		{
			cursor--;
			for (int i = 0; i < symbols.size(); i++)
			{
				if (tape[cursor] != symbols.get(i))
				{
					found = true;
				}
			}
		}
	}

	public boolean checkSymbol(char symbol)
	{
		return tape[cursor] == symbol;
	}

	public void setInput(char[] input)
	{
		tape = generateTapeWithString(String.copyValueOf(input)).toCharArray();

		cursor = (DEFAULT_SIZE / 4) - 1;
	}
	
	public static String generateTapeWithString(String input)
	{
		char[] tape = generateNewTape();
		
		int cursor = (DEFAULT_SIZE / 4);

		for (int i = 0; i < input.length(); i++)
		{
			tape[cursor] = input.charAt(i);
			cursor++;
		}
		return String.copyValueOf(tape);
	}
	
	private static char[] generateNewTape()
	{
		char[] tape = new char[DEFAULT_SIZE];
		for (int i = 0; i < DEFAULT_SIZE; i++)
		{
			tape[i] = BLANK;
		}
		return tape;
	}

	public void print()
	{
		printCursor();
		printTape();
		printState();
		printVariables();

		System.out.println();
	}

	public void printCursor()
	{
		for (int i = 0; i < cursor; i++)
		{
			System.out.print('-');
		}
		System.out.println('|');
	}

	public void printTape()
	{
		for (int i = 0; i < DEFAULT_SIZE; i++)
		{
			System.out.print(tape[i]);
		}
	}

	private void printState()
	{
		System.out.print(" STATE: " + state);
	}

	private void printVariables()
	{
		System.out.println(" X=" + x + " W=" + w);
	}

	public void store(char variable)
	{
		switch (variable)
		{
		case ('x'):
			x = tape[cursor];
			break;
		case ('w'):
			w = tape[cursor];
			break;
		default:
		}
	}

	public boolean checkX()
	{
		return x == tape[cursor];
	}

}
