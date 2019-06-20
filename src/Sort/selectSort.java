package Sort;

public class selectSort {
	public void selectSort(int[] a) {

		/*首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
		再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
		重复第二步，直到所有元素均排序完毕。*/

//		时间n2，空间1，inplace，不稳定
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
