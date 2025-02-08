import java.util.Scanner;

public class Bheem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (isArms(i))
                System.out.println(i);
        }
        sc.close();
    }

    public static boolean isArms(int n) {
        int x = n;
        int sum = 0;
        int len = String.valueOf(x).length();
        while (x > 0) {
            int r = x % 10;
            sum = sum + (int) Math.pow(r, len);
            x = x / 10;
        }
        return sum == n;
    }
}