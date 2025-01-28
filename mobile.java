package adjava;

import java.util.regex.Pattern;

public class mobile {
	public static void main(String[] args) {
		String s = "7989568498";
		String t = "+91 79895 68498";
		if(Pattern.matches("\\+[0-9]{1,4}\\s[0-9]{5}\\s[0-9]{5}", t)) System.out.println("true");
		else System.out.println("false");
	}
}
