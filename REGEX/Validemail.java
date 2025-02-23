package REGEX;

import java.util.regex.Pattern;

public class Validemail {
	public static void main(String[] args) {
		String a = "apple98.|_24@outlook";
		if (Pattern.matches("[a-zA-Z0-9\\.|_]*@[a-z]{4,8}\\.[a-z]{2,3}", a))
			System.out.println("Valid");
		else
			System.out.println("Invalid ");

	}
}
