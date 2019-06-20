package Sort;

public class heapSort {
//    时间nlogn，空间1，inplace，不稳定
    public void heapSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            creatMaxHeap(a, a.length - 1 - i);//构建0-length-1-i的最大堆
            swap(a, 0, a.length - 1 - i);//调整堆顶和最后一个（length-1-i)的值，保证最后是最大
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

        //从最后一个节点的父节点开始
        for (int i = (last - 1) / 2; i >= 0; i--) {
//			保存当前正在判断的节点
            int k = i;

//			如果当前k节点的子节点存在
            while (2 * k + 1 <= last) {
//				bigger记录较大节点的值，先赋值为当前节点左节点的索引
                int bigger = 2 * k + 1;
//				如果当前节点右子节点存在
                if (bigger + 1 <= last) {
                    if (a[bigger] < a[bigger + 1]) {
//						若右子节点值比左子节点的值大，则bigger记录右子节点的值
                        bigger++;
                    }
                }
//				如果k节点的值小于其较大子节点的值
                if (a[k] < a[bigger]) {
//					交换两者的值
                    swap(a, k, bigger);
//					将bigger赋予k，while循环下一次，重新保证k节点的值大于其左右子节点的值
                    k = bigger;
                } else {
                    break;
                }
            }

        }

    }

    public static void main(String[] args) {
        heapSort h = new heapSort();
        int[] a = {6, 5, 4, 3, 2, 1, 0};
        h.heapSort(a);
        for (int b :
                a) {
            System.out.print(b);
        }

    }
}
