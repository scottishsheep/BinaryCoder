package binary.coder;

import static binary.coder.helper.Helper.*;

public class BinaryCoder {

	private static char[] inputchararray;

	public static void main(String[] args) {
		while (true) {
			try {
				startprogram();
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
			System.out.println("Nochmal?");
			String in = getInput().toLowerCase();
			if (!in.equals("yes") && !in.equals("y") && !in.equals("ja") && !in.equals("j")) {
				break;
			}
		}

	}

	private static void startprogram() {
		System.out.println("Bitte gib einen 32-stelligen Binärcode an!");
		System.out.println("                               v");
		String eingabe = getInput();
		System.out.println("Deine Zahl ist: " + map(eingabe));
	}

	public static int map(String input) {
		if (input.length() > 32) {
			throw new IllegalArgumentException("Keine Zahlen länger als 32 Zeichen!");
		}
		while (input.length() < 32) {
			input = "0" + input;
		}
		inputchararray = input.toCharArray();

		for (char c : inputchararray) {
			if (c != '0' && c != '1') {
				throw new IllegalArgumentException("Nur die Ziffern '0' und '1' sind erlaubt!");
			}
		}

		int[] inputarray = new int[32];
		for (int i = 0; i < 32; i++) {
			inputarray[i] = Integer.parseInt(String.valueOf(inputchararray[i]));
		}
		int factor;
		if (inputarray[0] == 0) {
			factor = 1;
		} else {
			// negative Zahl
			// eins abziehen
			int erste1 = 0;
			boolean broken = false;
			LOOP: for (int i = inputarray.length - 1; i > 0; i--) {
				if (inputarray[i] == 1) {
					erste1 = i;
					broken = true;
					break LOOP;
				}
			}
			if (!broken) {
				return Integer.MIN_VALUE;
			}
			for (int j = erste1; j < inputarray.length; j++) {
				if (inputarray[j] == 1) {
					inputarray[j] = 0;
				} else {
					inputarray[j] = 1;
				}
			}

			// umdrehen
			for (int counter = 0; counter < inputarray.length; counter++) {
				inputarray[counter] = inputarray[counter] == 1 ? 0 : 1;
			}
			factor = -1;

		}
		int mynumber = 0;
		for (int j = 31; j > 0; j--) {
			if (inputarray[j] == 1)
				mynumber = (int) (mynumber + Math.pow(2, 31 - j));
		}

		return factor * mynumber;
	}
}
