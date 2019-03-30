package turingparser;

import java.util.ArrayList;

public class Chooser
{
	private int nextSequence;
	private boolean always;
	private boolean not;
	private ArrayList<Character> symbols;
	private boolean x;
	private boolean w;

	public Chooser(ArrayList<Character> symbols, boolean always, boolean not, boolean x, boolean w, int nextSequence)
	{
		this.nextSequence = nextSequence;
		this.always = always;
		this.not = not;
		this.symbols = symbols;
		this.x = x;
		this.w = w;
	}

	public boolean change()
	{
		if (always)
		{
			return true;
		}

		for (int i = 0; i < symbols.size(); i++)
		{
			if (x || w)
			{
				if (not)
				{
					if (x && GlobalMachine.getGlobalMachine().getX() != symbols.get(i))
					{
						return true;
					}

					if (w && GlobalMachine.getGlobalMachine().getW() != symbols.get(i))
					{
						return true;
					}
				} else
				{
					if (x && GlobalMachine.getGlobalMachine().getX() == symbols.get(i)
							&& GlobalMachine.getGlobalMachine().checkSymbol(symbols.get(i)))
					{
						System.out.println("VEROO!!!! x= " + GlobalMachine.getGlobalMachine().getX() + " sotto= "
								+ symbols.get(i));
						return true;
					}

					if (w && GlobalMachine.getGlobalMachine().getW() == symbols.get(i)
							&& GlobalMachine.getGlobalMachine().checkSymbol(symbols.get(i)))
					{
						return true;
					}
				}
			} else
			{
				if (not && !GlobalMachine.getGlobalMachine().checkSymbol(symbols.get(i)))
				{
					return true;
				}

				if (!not && GlobalMachine.getGlobalMachine().checkSymbol(symbols.get(i)))
				{
					return true;
				}
			}

		}
		return false;
	}

	public int nextSequence()
	{
		return nextSequence;
	}

	@Override
	public String toString()
	{
		return "Chooser [nextSequence=" + nextSequence + ", always=" + always + ", not=" + not + ", symbols=" + symbols
				+ ", x=" + x + ", w=" + w + "]";
	}

}
