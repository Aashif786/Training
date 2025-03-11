package INTERVIEWQUESTIONS;

import java.util.Scanner;

public class gameofthrones {
    public static void main(String[] args) {
        Scanner foo = new Scanner(System.in);
        String s = foo.nextLine();
        int a[] = new int[128];
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
        }
        for (int i : a) {
            if (i % 2 == 1)
                odd++;
        }
        if (odd > 1) {
            System.out.println("Not palindrome");
        } else {
            System.out.println("Palindrome");
        }
        foo.close();
    }
}
