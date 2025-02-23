package ALGORITHMS;

public class Select {
    public static void main(String[] args) {
        int arr[] = new int[] { 45, 78, 1, -3, 0, 56, 66, 42, 89, 65 };
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min)
                    min = j;
            }
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}