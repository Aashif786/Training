package DS;

import java.util.*;

public class Binary {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        Queue<Integer> qq = new LinkedList<>();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++)
            q.offer(Integer.toBinaryString(i));
        System.out.println();
        for (int i = 1; i <= n; i++)
            System.out.println(q.poll());

        System.out.println("Concatenation");
        q.offer("1");
        for (int i = 0; i < n; i++) {
            String x = q.poll();
            q.offer(x + "0");
            q.offer(x + "1");
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.println("Balu Algorithm ");

        qq.add(1);
        for (int i = 0; i < n; i++) {
            int x = qq.poll();
            qq.offer(x * 10);
            qq.offer(x * 10 + 1);
            System.out.print(x + " ");
        }
        s.close();
    }
}
