package Sort;

public class mergeSort {
	public void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);

	}

	private void mergeSort(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			mergeSort(a, low, mid, high);
		}

	}

	private void mergeSort(int[] a, int low, int mid, int high) {
		int[] tmp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
			
			while(i<=mid) {
				tmp[k++]=a[i++];
			}
			while(j<=high) {
				tmp[k++]=a[j++];
			}
			
			for(int k2=0;k2<tmp.length;k2++) {
				a[low+k2]=tmp[k2];
			}
		}

	}
}
