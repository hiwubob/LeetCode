package JIANZHIOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T27zifuchuandepailie {

        public ArrayList<String> Permutation(String str) {
            List<String> resultList = new ArrayList<>();
            if(str.length() == 0)
                return (ArrayList)resultList;
            //�ݹ�ĳ�ʼֵΪ��str���飬�յ�list����ʼ�±�0��
            fun(str.toCharArray(),resultList,0);
            Collections.sort(resultList);
            return (ArrayList)resultList;
        }

        private void fun(char[] ch,List<String> list,int i){
            //���ǵݹ����ֹ����������i�±��Ѿ��Ƶ�char�����ĩβ��ʱ��
            //���������һ���ַ�������������
            if(i == ch.length-1){
                //�ж�һ���Ƿ��ظ�
                if(!list.contains(new String(ch))){
                    list.add(new String(ch));
                    return;
                }
            }else{
                for(int j=i;j<ch.length;j++){
                    swap(ch,i,j);
                    fun(ch,list,i+1);
                    swap(ch,i,j);
                }
            }
        }

        //��������������±��Ԫ��
        private void swap(char[] str, int i, int j) {
            if (i != j) {
                char t = str[i];
                str[i] = str[j];
                str[j] = t;
            }
        }

    public static void main(String[] args) {
        T27zifuchuandepailie t=new T27zifuchuandepailie();
        ArrayList<String> a=new ArrayList<>();
        a = t.Permutation("abc");
        System.out.println(a);
    }
}

