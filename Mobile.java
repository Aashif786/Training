package adjava;

import java.util.regex.Pattern;

public class Mobile {
	public static void main(String[] args) {
		String t = "+91 97695 86798";
		if(Pattern.matches("\\+[0-9]{1,3}\\s[6-9]{1}[0-9]{4}\\s[0-9]{5}", t)) System.out.println("tamil number");
		else  System.out.println("other state");
	}
}
