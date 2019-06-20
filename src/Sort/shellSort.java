package Sort;

public class shellSort {

//	Ê±¼änlogn£¬¿Õ¼ä1
	public void shellSort(int[] a) {
		int dk=a.length/2;
		while(dk>=1) {
			shellSort(a,dk);
			dk=dk/2;
		}
	}

	private void shellSort(int[] a, int dk) {

		for(int i=dk;i<a.length;i++) {
			int tmp=a[i];
			int j;
			for(j=dk;j>=0&&a[j]>tmp;j=j-dk) {
				a[j+dk]=a[j];
			}
			a[j+dk]=tmp;
		}
	}

	public void shellSort2(int[] a) {
		for (int gap = a.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < a.length; i++) {
				for (int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
					a[j] = a[j] + a[j + gap];
					a[j + gap] = a[j] - a[j + gap];
					a[j] = a[j] - a[j + gap];
				}
			}
		}
	}

	public static void main(String[] args) {
		shellSort s=new shellSort();
		int[] a={2,6,7,4,8,3};
		s.shellSort2(a);
		for (int b :
				a) {
			System.out.print(b);
		}

	}
}
