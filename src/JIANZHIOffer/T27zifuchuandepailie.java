package JIANZHIOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T27zifuchuandepailie {

        public ArrayList<String> Permutation(String str) {
            List<String> resultList = new ArrayList<>();
            if(str.length() == 0)
                return (ArrayList)resultList;
            //递归的初始值为（str数组，空的list，初始下标0）
            fun(str.toCharArray(),resultList,0);
            Collections.sort(resultList);
            return (ArrayList)resultList;
        }

        private void fun(char[] ch,List<String> list,int i){
            //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，
            //考虑添加这一组字符串进入结果集中
            if(i == ch.length-1){
                //判断一下是否重复
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

        //交换数组的两个下标的元素
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

