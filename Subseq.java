public class Subseq {
    public int a[][];
    public int b[][];

    public Subseq(String s1, String s2) {
        a = new int[s2.length() + 1][s1.length() + 1];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                a[i][j] = -1;

        b = new int[s2.length() + 2][s1.length() + 2];
        for (int i = 0; i <= b.length; i++)
            for (int j = 0; j <= b[0].length; j++)
                if (i == 0 || j == 0)
                    a[i][j] = 0;
                else
                    a[i][j] = -1;

    }

    public static void main(String[] args) {
        String s1 = "ABCDrgc";
        String s2 = "ACBDecrg";
        Subseq s = new Subseq(s1, s2);
        System.out.println(s.backtrack(s1, s2, 0, 0));

    }

    int backtrack(String s1, String s2, int i, int j) {

        if (i == s1.length() || j == s2.length())
            return 0;

        if (a[i][j] != -1)
            return a[i][j];

        else if (s1.charAt(i) == s2.charAt(j))
            return a[i][j] = 1 + backtrack(s1, s2, i + 1, j + 1);

        return a[i][j] = Math.max(backtrack(s1, s2, i, j + 1), backtrack(s1, s2, i + 1, j));
    }

    int table(String s1, String s2, int i, int j) {
        for (int i = 0; i <= b.length; i++)
            for (int j = 0; j <= b[0].length; j++)
                if (i == 0 || j == 0)
                    a[i][j] = 0;
                else
                    a[i][j] = -1;
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