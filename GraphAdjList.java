import java.util.*;

class graph {
    int gr[][];
    int n;

    graph(int s) {
        n = s;
        gr = new int[n][n];
    }

    void addEdge(int start, int end, int w) {
        gr[start][end] = w;
        // gr[end][start]=w; remove if it's directed graph
    }

    void removeEdge(int start, int end) {
        gr[start][end] = 0;
        gr[end][start] = 0;// remove if its directed
    }

    void display() {
        for (int i = 0; i < n; i++, System.out.println())
            for (int j = 0; j < n; j++)
                System.out.print(gr[i][j] + " ");

        System.out.println();
    }
}

public class GraphAdjList {
    public static void main(String ar[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        graph g1 = new graph(n);
        for (int i = 1; i <= e; i++) {
            int start = s.nextInt();
            int end = s.nextInt();
            int weight = s.nextInt();
            g1.addEdge(start, end, weight);
        }
        g1.display();
        s.close();
    }
}
