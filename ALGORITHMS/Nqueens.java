package ALGORITHMS;

import java.util.*;

public class Nqueens {
    static int[][] board;
    static int n;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        board = new int[n][n];
        if (queen(0))
            printboard(); // 0 = column no upto 3(since n = 4)
        else
            System.out.println("No Solution");
        s.close();
    }

    static boolean safe(int r, int c) {
        for (int j = 0; j < c; j++)
            if (board[r][j] == 1)
                return false;

        for (int i = r - 1, j = c - 1; j >= 0 && i >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = r + 1, j = c - 1; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean queen(int qn) {
        if (n == qn)
            return true;
        else {
            for (int i = 0; i < n; i++) {
                if (safe(i, qn)) {
                    board[i][qn] = 1;
                    if (queen(qn + 1))
                        return true;
                    board[i][qn] = 0;
                }
            }
            return false;
        }
    }

    static void printboard() {
        for (int i = 0; i < board.length; i++, System.out.println()) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }
}
