public class Mat {
	public static void main(String[] args) {
		int[][] a = {
				{ 1, 4, 2 },
				{ 6, 3, 9 },
				{ 5, 7, 4 }
		};

		// minimum of each row
		for (int i = 0; i < a.length; i++) {
			int min = a[i][0];
			for (int j = 0; j < a[0].length; j++)
				if (a[i][j] < min)
					min = a[i][j];
		}

		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < a[0].length; j++)
					System.out.print(a[i][j] + " ");
			} else {
				for (int j = a[0].length - 1; j >= 0; j--)
					System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}