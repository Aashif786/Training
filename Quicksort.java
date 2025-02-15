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
