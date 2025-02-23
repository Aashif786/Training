package DS;

import java.util.Scanner;
import java.util.Arrays;

public class RemoveMidLinked {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    s.nextLine();
    int[] a = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int n = s.nextInt();
    s.nextLine();
    int[] b = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    linked l1 = new linked();
    linked l2 = new linked();

    node h1 = l1.list(a, m);
    node h2 = l2.list(b, n);
    l1.sw(h1, h2);
    s.close();
  }
}

class node {
  int data;
  node next;

  node(int d) {
    data = d;
    next = null;
  }
}

class linked {
  node head = null;

  public node list(int[] ar, int n) {

    node h = new node(ar[0]);
    node head = h;
    node temp = head;
    for (int i = 1; i < n; i++) {
      node nn = new node(ar[i]);
      temp.next = nn;
      temp = temp.next;
    }
    return head;
  }

  public void sw(node h1, node h2) {
    node t1 = h1;
    node t2 = h2;
    int i = 0;
    while (t1 != null || t2 != null) {
      if (i % 2 == 0) {
        System.out.print(t1.data + " ");
        t1 = t1.next;
      } else {
        System.out.print(t2.data + " ");
        t2 = t2.next;
      }
      i++;
    }
  }
}
