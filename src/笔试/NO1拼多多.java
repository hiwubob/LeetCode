package ����;

import java.util.Arrays;
import java.util.Scanner;

public class NO1ƴ��� {
    /*    �����ϸ�����
        ������������A��B����������A�Ǽ����ϸ��������еģ�
        �����Ķ�����ֻ��ı�����һ����������������ȫ�������С�
        ��������Ǵ�A���ҵ�������飬��������B��ѡȡһ����������棬
        ʹ��A���ϸ��������еģ����ҳ�B������Ҫ���������֣�������������飬�粻���������NO��*/

/*    ����A=[1,3,8,7,10]��Υ���ϸ������������������������8Ҳ������7��
    ����Ļ���˼·�Ǵ�A���ҵ����������飬���ҵõ��滻���ֵ��������䣬
    ֮���ٴӴ�С����B�����Ƿ�������������������֮һ�����֡��������Ҿ͹���65��
    д��ƪpost ��ʱ��ſ�����ĿҪ��������֣����Ҳ�û�ж�B����o(T��To)*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] aa = in.nextLine().split(" ");
            String[] bb = in.nextLine().split(" ");
            int[] a = new int[aa.length];
            int[] b = new int[bb.length];
            for (int i = 0; i < aa.length; i++) {
                a[i] = Integer.valueOf(aa[i]);
            }
            for (int i = 0; i < bb.length; i++) {
                b[i] = Integer.valueOf(bb[i]);
            }


            int cur = 0;
            for (; cur < a.length - 1; cur++) {
                if (a[cur] >= a[cur + 1]) {
                    break;
                }
            }
            int left1 = cur == 0 ? Integer.MIN_VALUE : a[cur - 1];
            int right1 = a[cur + 1];
            int left2 = a[cur];
            int right2 = cur == a.length - 2 ? Integer.MAX_VALUE : a[cur + 2];

//            Ҫ�� b ����������򣬴Ӻ���ǰ��
            Arrays.sort(b);

            int i = b.length - 1;
            for (; i >= 0; --i) {
                if (left1 < b[i] && b[i] < right1) {
                    a[cur] = b[i];
                    break;
                } else if (left2 < b[i] && b[i] < right2) {
                    a[cur+1]=b[i];
                    break;
                }
            }

            if (i == -1) {
                System.out.println("NO");
            } else {
                for (int j = 0; j < a.length; j++) {
                    System.out.println(a[i]);
                    if (i != a.length - 1) {
                        System.out.println(" ");
                    }
                }
                System.out.println("\n");
            }

        }
    }
}
