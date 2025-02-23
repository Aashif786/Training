package DS;

import java.util.*;

class node {
    int data;
    node next;

    node(int d) {
        data = d;
        next = null;
    }
}

class linkedlist {
    node head = null;

    void insert(int d) {
        node nnode = new node(d);
        if (head == null)
            head = nnode;
        else {
            node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = nnode;
        }
    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        // System.out.println();
    }
}

class graph {
    int n;
    linkedlist gr[];

    graph(int s) {
        n = s;
        gr = new linkedlist[n];
        for (int i = 0; i < n; i++)
            gr[i] = new linkedlist();
    }

    void addEdge(int start, int end) {
        gr[start].insert(end);
        gr[end].insert(start);
    }

    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print("Node started from " + i + " -> ");
            gr[i].display();
            System.out.println();
        }
    }
}

public class GraphAdjList {
    public static void main(String ar[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        graph g1 = new graph(n);
        for (int i = 0; i < e; i++) {
            int start = s.nextInt();
            int end = s.nextInt();
            g1.addEdge(start, end);
        }
        g1.display();
        s.close();
    }
}
