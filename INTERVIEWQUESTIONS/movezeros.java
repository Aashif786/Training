package INTERVIEWQUESTIONS;

import java.util.Arrays;
import java.util.Scanner;

public class movezeros {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);

        int a = 0;

        int nums[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[a] = nums[i];
                a++;
            }
        }
        for (int j = a; j < nums.length; j++) {
            nums[j] = 0;
        }
        sc.close();
    }
}