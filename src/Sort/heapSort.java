package Sort;

public class heapSort {
//    ʱ��nlogn���ռ�1��inplace�����ȶ�
    public void heapSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            creatMaxHeap(a, a.length - 1 - i);//����0-length-1-i������
            swap(a, 0, a.length - 1 - i);//�����Ѷ������һ����length-1-i)��ֵ����֤��������
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

        //�����һ���ڵ�ĸ��ڵ㿪ʼ
        for (int i = (last - 1) / 2; i >= 0; i--) {
//			���浱ǰ�����жϵĽڵ�
            int k = i;

//			�����ǰk�ڵ���ӽڵ����
            while (2 * k + 1 <= last) {
//				bigger��¼�ϴ�ڵ��ֵ���ȸ�ֵΪ��ǰ�ڵ���ڵ������
                int bigger = 2 * k + 1;
//				�����ǰ�ڵ����ӽڵ����
                if (bigger + 1 <= last) {
                    if (a[bigger] < a[bigger + 1]) {
//						�����ӽڵ�ֵ�����ӽڵ��ֵ����bigger��¼���ӽڵ��ֵ
                        bigger++;
                    }
                }
//				���k�ڵ��ֵС����ϴ��ӽڵ��ֵ
                if (a[k] < a[bigger]) {
//					�������ߵ�ֵ
                    swap(a, k, bigger);
//					��bigger����k��whileѭ����һ�Σ����±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
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
