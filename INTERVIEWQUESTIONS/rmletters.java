package INTERVIEWQUESTIONS;

public class rmletters {
    public static void main(String[] args) {
        String a = "computer";
        String b = "rat";
        for (char c : b.toCharArray()) {
            if (a.contains(String.valueOf(c))) a = a.replace(String.valueOf(c), "");
        }
        System.out.println(a);
    }
}
