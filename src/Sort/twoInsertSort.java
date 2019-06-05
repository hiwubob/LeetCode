package Sort;

public class twoInsertSort {
	public void twoInsertSort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			int tmp = a[i];
			int left = 0;
			int right = i - 1;
			int mid;
			while (left < right) {
				mid = (left + right) / 2;
				if (tmp < a[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				a[j + 1] = a[j];
			}
			if (left != i) {
				a[left] = tmp;
			}
		}

	}
}
