package Sort;

public class selectSort {
	public void selectSort(int[] a) {

		int min;
		for(int i=0;i<a.length;i++) {
			min=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min])
					min=j;
				
			}
			swap(a,i,min);
		}
		
	}

	private void swap(int[] a, int i, int j) {
		if(i==j)
			return;
		a[i]=a[i]+a[j];
		a[j]=a[i]-a[j];
		a[i]=a[i]-a[j];
		
		
	}
	
}
