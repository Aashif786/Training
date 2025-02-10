import java.util.Scanner;
import java.util.Arrays;

public class AlternateLinked {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    s.nextLine();
    int[] a = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int n = s.nextInt();
    s.nextLine();
    int[] b = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    linked ll = new linked();
    linked l2 = new linked();

    node h1 = ll.list(a, m);
    node h2 = ll.list(b, n);

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

  public node list(int[] a, int n) {

    node h = new node(a[0]);
    node head = h;
    node temp = head;
    for (int i = 1; i < n; i++) {
      node nn = new node(a[i]);
      temp.next = nn;
      temp = temp.next;
    }
    return head;
  }

  public void display(node head) {
    node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  // public void switch(){}
}