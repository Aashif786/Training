import java.util.regex.*;

public class Rgx {
	public static void main(String[] args) {
		// String a = "Karikalan";
		String v = "Cholan Karikalan";
		if (Pattern.matches(".*\\sKarikalan", v))
			System.out.println("true");
		else
			System.out.println("false");

	}
}
