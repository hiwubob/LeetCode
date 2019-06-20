package Sort;

public class quickSort {

	//时间 nlogn      空间nlogn   inplace 不稳定
	public void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int middle = getMiddle(a, low, high);
			quickSort(a, 0, middle - 1);//递归对低子表递归排序
			quickSort(a, middle + 1, high);//递归对高字表递归排序
		}

	}

	private int getMiddle(int[] a, int low, int high) {
		int key = a[low];//基准元素，排序中会空出一个位置
		while (low < high) {
			while (low < high && a[high] >= key) {//从high开始找比基准小的，与low交换
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] < key) {//从low开始找比急转大的，与之前high空出来的交换
				low++;

			}
			a[high] = a[low];
		}
		a[low] = key;

		return low;
	}

	public static void main(String[] args) {
		int[] a = {6, 4, 7, 3, 8, 3};
		quickSort s = new quickSort();
		s.quickSort(a);
		for (int b : a) {
			System.out.print(b);
		}
	}
}
