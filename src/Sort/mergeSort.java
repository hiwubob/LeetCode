package Sort;

public class mergeSort {
//	时间nlogn，空间n，outplace，稳定
	public void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);

	}

	private void mergeSort(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
//			左边
			mergeSort(a, low, mid);
//			右边
			mergeSort(a, mid + 1, high);
//			左右归并
			mergeSort(a, low, mid, high);
		}

	}

	private void mergeSort(int[] a, int low, int mid, int high) {
		int[] tmp = new int[high - low + 1];
		int i = low;//左指针
		int j = mid + 1;//右指针
		int k = 0;

//		把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
//			把左边剩余的数移入数组
			while(i<=mid) {
				tmp[k++]=a[i++];
			}
//			把右边的剩余的数一道数组
			while(j<=high) {
				tmp[k++]=a[j++];
			}
//			把新数组中的数覆盖a数组
			for(int k2=0;k2<tmp.length;k2++) {
				a[low+k2]=tmp[k2];
			}
		}

	}
}
