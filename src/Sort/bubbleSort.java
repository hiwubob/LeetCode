package Sort;

public class bubbleSort {
	public void bubbleSort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	public void bubbleSort2(int[] a) {
		int low = 0;
		int high = a.length - 1;
		int i;
		while (low < high) {
			for (i = low; i < high; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
				}
			}
			high--;
			for (i = high; i > low; i--) {
				if (a[i] < a[i - 1]) {
					swap(a, i, i - 1);
				}
				low++;
			}
		}
	}

	private void swap(int[] a, int j, int i) {
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];
	}
}
