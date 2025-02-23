package ALGORITHMS;

public class Mergesort {
	public static void main(String[] args) {
		int arr[] = new int[] { 45, 78, 1, -3, 0, 56, 66, 42, 89, 65 };
		int n = arr.length;
		sort(0, n - 1, arr);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	static void merge(int arr[], int low, int high, int mid) {
		int n1 = mid - low + 1;
		int n2 = high - mid;

		int arr1[] = new int[n1];
		int arr2[] = new int[n2];

		for (int i = 0; i < n1; i++)
			arr1[i] = arr[low + i];
		for (int j = 0; j < n2; j++)
			arr2[j] = arr[j + mid + 1];

		int i = 0, j = 0, s = low;

		while (i < n1 && j < n2) {
			if (arr1[i] <= arr2[j])
				arr[s++] = arr1[i++];
			else
				arr[s++] = arr2[j++];
		}
		while (i < n1)
			arr[s++] = arr1[i++];
		while (j < n2)
			arr[s++] = arr2[j++];
	}

	static void sort(int low, int high, int arr[]) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			sort(low, mid, arr);
			sort(mid + 1, high, arr);
			merge(arr, low, high, mid);
		}
	}
}