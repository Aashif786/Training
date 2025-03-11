package INTERVIEWQUESTIONS;

import java.util.Scanner;

public class Harry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a[] = { "abcba", "abd", "aaccda" };
        int[] op = new int[a.length];
        int x = 0;
        for (String i : a) {
            op[x++] = bheem(i);
        }

        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j] + " - " + op[j]);
        }

        sc.close();
    }

    static int bheem(String s) {
        int st = 0;
        int end = s.length() - 1;
        int ops = 0;
        while (st < end) {
            ops += Math.abs(s.charAt(st) - s.charAt(end));
            st++;
            end--;
        }
        return ops;
    }
}
