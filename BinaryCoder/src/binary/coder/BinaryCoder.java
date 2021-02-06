package binary.coder;

import static binary.coder.helper.Helper.*;

public class BinaryCoder {

	private static char[] inputchararray;

	public static void main(String[] args) {
		startprogram();

	}

	private static void startprogram() {
		System.out.println("Bitte gib einen 32-stelligen Binärcode an!");
		String eingabe = getInput();
		check(eingabe);

	}

	public static int map(String input) {
		// TODO: Implementation
		inputchararray = input.toCharArray();
		int[] inputarray = new int[32];
		for (int i = 0; i < 32; i++) {
			inputarray[i] = Integer.parseInt(String.valueOf(inputchararray[i]));
		}
		int factor;
		if (inputarray[0] == 0)
			factor = 1;
		else
			factor = -1;
		int mynumber=0;
		for (int j=31; j>0; j--)
		{if (inputarray[j]==1)
			mynumber=(int) (mynumber+Math.pow(2, 31-j));}
		
		return factor*mynumber;
	}

	private static void check(String eingabe) {
		if (eingabe.length() != 32) {
			System.out.println(eingabe.length());
			startprogram();
			return;
		} else

		{
			map(eingabe);
			System.out.println("Deine Zahl ist: " + map(eingabe));
			System.out.println("Nochmal? (J macht weiter)");
			String eingabeneu = getInput();
			if (eingabeneu.equals("J"))
				startprogram();
			else return;
		}
	}

}
