package INTERVIEWQUESTIONS;

import java.util.*;

public class arrayshift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        int n = a.length;
        k = k % n;
        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    static void reverse(int[] a, int st, int end) {
        while (st < end) {
            int t = a[st];
            a[st] = a[end];
            a[end] = t;
            st++;
            end--;
        }
    }
}
