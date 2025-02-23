package DS;

import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

public class queuestackpalindrome {
    public static void main(String[] args) {
        Queue<Integer> pq = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        int x = 12821;
        while (x > 0) {
            int n = x % 10;
            pq.offer(n);
            st.add(n);
            x /= 10;
        }
        int flag = 1;
        while (!pq.isEmpty()) {
            if (pq.poll() != st.pop()) {
                flag = 0;
                break;
            }
        }
        System.out.println(flag);
    }
}
