public class smurfs {
    public static void main(String[] args) {
        int n = 5;
        char [] a = {'R', 'G', 'B', 'R', 'B'};
        hello(n, a);

    }
    
    static int hello(int n, char[] a) {
        int r = 0, g = 0, b = 0;

        for (char c : a) {
            switch (c) {
                case 'R' -> r++;
                case 'G' -> g++;
                case 'B' -> b++;
                default -> {
                }
            }
        }

        if ((r == n) || (g == n) || (b == n)) return n;

        if ((r % 2 == g % 2) && (g % 2 == b % 2)) return 2;

        return 1;
    }
}
