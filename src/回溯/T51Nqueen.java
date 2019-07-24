package 回溯;

import java.util.ArrayList;
import java.util.List;

public class T51Nqueen{

	List<List<String>> res = new ArrayList<>();

     
    public int totalNQueens(int n) {
        //list的索引代表行号，value代表该行的列号
        List<Integer> list = new ArrayList<>();
        getRes(n,0,list); 
        return res.size();
    }
    public void getRes(int n,int index,List<Integer> list){
        if(index == n){
            //已经找到一个安置方法
            List<Integer> perList = new ArrayList(list);
            List<String> strList = new ArrayList();
            //转化为字符串形式
            for(Integer per : perList){
                StringBuffer buff = new StringBuffer();
                for(int i=0;i<n;i++){
                    if(i==per)
                        buff.append("Q");
                    else
                        buff.append(".");
                }
                strList.add(buff.toString());
            }
            res.add(strList);
        }else{
            P:for(int i=0;i<n;i++){
                //cheak,该行的i位置是否可行
                //该列上是否已经存在皇后
                if(!list.contains(i)){
                    //行差等于列差，说明左斜线或者右斜线同时有两个互相攻击的皇后     i是列 k是行号 get（k）=列
                    int size = list.size();//size 行数
                    for(int k=0;k<size;k++){
                        if(size-k == Math.abs(i-list.get(k)))
                           continue P; 
                    }
                    //此时可以保证该行的第i列可以放皇后
                    list.add(i);
                    //考虑下一行
                    getRes(n,index+1,list);
                    //考虑该行的下一个取值
                    list.remove(list.size()-1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
		T51Nqueen t=new T51Nqueen();
		int res;
		res=t.totalNQueens(4);
		System.out.println(res);
	}
}
