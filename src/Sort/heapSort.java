package Sort;

public class heapSort {
	public void heapSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			creatMaxHeap(a, a.length - 1 - i);
			swap(a, 0, a.length - 1 - i);
		}

	}

	private void swap(int[] a, int i, int j) {
		if (i == j)
			return;
		a[i] = a[i] + a[j];
		a[j] = a[i] - a[j];
		a[i] = a[i] - a[j];

	}

	private void creatMaxHeap(int[] a, int last) {
		for (int i = (last - 1) / 2; i >= 0; i--) {
			int k = i;

			while (2 * k + 1 <= last) {
				int bigger = 2 * k + 1;
				if (bigger + 1 <= last) {
					if (a[bigger] < a[bigger + 1]) {
						bigger++;
					}
				}
				if (a[k] < a[bigger]) {
					swap(a, k, bigger);
					k = bigger;
				} else {
					break;
				}
			}

		}

	}
}
