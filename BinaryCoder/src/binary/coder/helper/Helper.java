package binary.coder.helper;

import java.util.Scanner;

public class Helper {
	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
//		sc.close();
		return input;
	}
}
