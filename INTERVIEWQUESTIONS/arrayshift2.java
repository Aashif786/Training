package INTERVIEWQUESTIONS;

import java.util.*;

public class arrayshift2 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = a.length;

        int x = n - 1;
        int i = 0;
        while (i < x) {
            if (a[i] % 10 == 0) {
                int t = a[i];
                a[i] = a[x];
                a[x] = t;
                i++;
                x--;
            }
        }
        for (int e : a) {
            System.out.print(e + " ");
        }
    }

}
