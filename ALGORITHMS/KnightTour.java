package ALGORITHMS;

public class KnightTour {
    static int board[][];
    static int n;
    static int rowmv[] = { -2, -2, -1, 1, 2, 2, -1, 1 };
    static int colmv[] = { -1, 1, -2, -2, -1, 1, 2, 2 };

    static boolean safe(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < n && board[i][j] == -1)
            return true;
        else
            return false;
    }

    static boolean knight(int move, int i, int j) {
        if (move == n * n)
            return true;
        for (int k = 0; k < n; k++) {
            int row = i + rowmv[k];
            int col = i + colmv[k];
            if (safe(row, col)) {
                board[i][j] = move;
                if (knight(+1, row, col)) {
                    return true;
                }
                board[i][j] = -1;
            }
        }
        return false;
    }

    public static void printboard() {
        for (int i = 0; i < board.length; i++, System.out.println()) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        n = 8;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }
        board = new int[n][n];
        if (knight(1, 0, 0)) {
            printboard();
        }
    }
}
