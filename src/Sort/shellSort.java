package Sort;

public class shellSort {

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
}
