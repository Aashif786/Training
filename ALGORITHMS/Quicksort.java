package ALGORITHMS;

public class Quicksort {
    static void quick(int a[], int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quick(a, low, p - 1);
            quick(a, p + 1, high);

        }
    }

    static int partition(int a[], int low, int high) {
        int i = low - 1;
        int pivot = a[high];
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                // Swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // Swap pivot with a[i+1]
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int a[] = { 88, 34, 21, 5, 32, 21, 6, 90, 18, 55 };
        int n = 10;
        quick(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
