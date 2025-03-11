import java.util.*;

public class arrayshift {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        int k = 3;
        int n = a.length;
        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
        // List<Integer> l = new ArrayList<>();
        // for (int i = k; i < a.length; i++) {
        // l.add(a[i]);
        // }
        // for (int i = 0; i < k; i++) {
        // l.add(a[i]);
        // }
        // for (int i : l) {
        // System.out.print(i + " ");
        // }
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
