package Sort;

public class quickSort {

	//ʱ�� nlogn      �ռ�nlogn   inplace ���ȶ�
	public void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int middle = getMiddle(a, low, high);
			quickSort(a, 0, middle - 1);//�ݹ�Ե��ӱ�ݹ�����
			quickSort(a, middle + 1, high);//�ݹ�Ը��ֱ�ݹ�����
		}

	}

	private int getMiddle(int[] a, int low, int high) {
		int key = a[low];//��׼Ԫ�أ������л�ճ�һ��λ��
		while (low < high) {
			while (low < high && a[high] >= key) {//��high��ʼ�ұȻ�׼С�ģ���low����
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] < key) {//��low��ʼ�ұȼ�ת��ģ���֮ǰhigh�ճ����Ľ���
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
