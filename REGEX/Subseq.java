package REGEX;

public class Subseq {
    public int a[][];
    public int b[][];

    public Subseq(String s1, String s2) {
        int m = s2.length();
        int n = s1.length();

        a = new int[m + 1][n + 1];
        b = new int[m + 1][n + 1];

        // Initialize 'a' array with -1 for memoization
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                a[i][j] = -1;

        // Initialize 'b' array with 0s for table-based computation
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                b[i][j] = 0;
    }

    public static void main(String[] args) {
        String s1 = "ABCDrgc";
        String s2 = "ACBDecrg";
        Subseq s = new Subseq(s1, s2);
        System.out.println("LCS Length (Recursion): " + s.backtrack(s1, s2, 0, 0));
        System.out.println("LCS Length (DP Table): " + s.table(s1, s2));
    }

    // Memoized Recursive LCS Calculation
    int backtrack(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;

        if (a[i][j] != -1)
            return a[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return a[i][j] = 1 + backtrack(s1, s2, i + 1, j + 1);

        return a[i][j] = Math.max(backtrack(s1, s2, i, j + 1), backtrack(s1, s2, i + 1, j));
    }

    // Iterative Table-Based LCS Calculation
    int table(String s1, String s2) {
        int m = s2.length();
        int n = s1.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s2.charAt(i - 1) == s1.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}

// int backtrack(String s1, String s2, int i, int j) {
// if (i == s1.length() || j == s2.length()) {
// if (a[i][j] == -1)
// a[i][j] = 0;
// return a[i][j];
// } else if (s1.charAt(i) == s2.charAt(j)) {
// if (a[i][j] == -1)
// a[i][j] = 1 + backtrack(s1, s2, i + 1, j + 1);
// return a[i][j];
// }
// a[i][j + 1] = (a[i][j + 1] == -1) ? 1 + backtrack(s1, s2, i, j + 1) : -1;
// a[i][j + 1] = (a[i + 1][j] == -1) ? 1 + backtrack(s1, s2, i + 1, j) : -1;
// return a[i][j] = Math.max(a[i][j + 1], a[i + 1][j]);