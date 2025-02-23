package ALGORITHMS;

import java.util.*;

class graph {
    int gr[][];
    int n;

    graph(int s) {
        n = s;
        gr = new int[n][n];
    }

    void addEdge(int start, int end) {
        gr[start][end] = 1;
        gr[end][start] = 1; // remove if it's directed graph
    }

    void removeEdge(int start, int end) {
        gr[start][end] = 0;
        gr[end][start] = 0;// remove if its directed
    }

    void BFS(int start) {
        boolean visited[] = new boolean[n];
        Queue<Integer> q1 = new LinkedList<>();
        q1.offer(start);
        visited[start] = true;
        System.out.print(start + " ");
        while (!q1.isEmpty()) {
            for (int j = 0; j < n; j++) {
                if (gr[q1.peek()][j] == 1 && !visited[j]) {
                    System.out.print(j + " ");
                    visited[j] = true;
                    q1.offer(j);
                }
            }
            q1.poll();
        }
    }

    void DFSprint(boolean visited[], int i) {
        for (int j = 0; j < n; j++) {
            if (gr[i][j] == 1 && !visited[j]) {
                System.out.print(j + " ");
                visited[j] = true;
                DFSprint(visited, j);
            }
        }
    }

    void DFS(int start) {
        boolean visited[] = new boolean[n];
        System.out.print(start + " ");
        visited[start] = true;
        DFSprint(visited, start);
    }

    void display() {
        for (int i = 0; i < n; i++, System.out.println())
            for (int j = 0; j < n; j++)
                System.out.print(gr[i][j] + " ");

        System.out.println();
    }

}

public class BFSDFS {
    public static void main(String ar[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        graph g1 = new graph(n);
        for (int i = 1; i <= e; i++) {
            int start = s.nextInt();
            int end = s.nextInt();
            g1.addEdge(start, end);
        }
        g1.BFS(2);
        s.close();
    }
}
