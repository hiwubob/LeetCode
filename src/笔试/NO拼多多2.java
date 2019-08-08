package ����;

import java.util.ArrayList;
import java.util.Scanner;

public class NOƴ���2 {
    /*����һ���ַ������飨�ַ������Ⱥ����鳤�Ⱦ�����1��С��1024����
    �����ַ���Ϊ��д��ĸ�����ʣ��������ַ��������Ƿ���ͨ������������Ԫ�ص�˳��
    �Ӷ���β�������γ�һ������*/


//    ��Ŀ������Ӧ����һ���������⣬���û����г��������У��ж��Ƿ���β������


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String [] words=in.nextLine().split(" ");
            if (words == null || words.length < 2) {
                System.out.println("false" );
            }
            boolean[] isUsed = new boolean[words.length];
            boolean flag = backtrace(words, new ArrayList<String>(), isUsed);
            if (flag) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    private static boolean backtrace(String[] words, ArrayList<String> curList, boolean[] isUsed) {
        boolean flag=false;
        if (words.length == curList.size()) {
            String first = curList.get(0);
            String last = curList.get(curList.size() - 1);
            return last.charAt(last.length() - 1) == first.charAt(0);
        }

        for (int i = 0; i < words.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (curList.size() == 0) {
                curList.add(words[i]);
            } else {
                String prev = curList.get(curList.size() - 1);
                if (prev.charAt(prev.length() - 1)!=words[i].charAt(0)) {
                    continue;
                }
                curList.add(words[i]);
            }

            isUsed[i] = true;
            flag = backtrace(words, curList, isUsed);
            isUsed[i]=false;
            curList.remove(curList.size() - 1);
            if (flag) {
                break;
            }
        }
        return false;

    }
}
