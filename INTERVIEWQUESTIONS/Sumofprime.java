package INTERVIEWQUESTIONS;

public class Sumofprime {
    public static void main(String[] args) {
        int n = 15;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (isprime(i))
                sum += i * i;
        }
        System.err.println(sum);
    }

    static boolean isprime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
