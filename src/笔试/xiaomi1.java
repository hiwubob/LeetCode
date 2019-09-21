package 笔试;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class xiaomi1 {

    private static int i=0;

    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    //int i=0;
    public static TreeNode str2tree(String s) {
        // write your code here
        if("".equals(s)){
            return null;
        }
        Stack<TreeNode> nodes=new Stack<>();
        TreeNode root=null;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch==')'){
                nodes.pop();
                i++;
            }
            else if(ch=='('){
                i++;
                int val=getVal(s);
                TreeNode q=new TreeNode(val);
                TreeNode temp=nodes.peek();
                if(temp.left==null){
                    temp.left=q;
                }else if(temp.right==null){
                    temp.right=q;
                }
                nodes.push(q);
            }
            else if(ch=='-'||(ch>='0'&&ch<='9')){
                int val=getVal(s);
                if(root==null){
                    root=new TreeNode(val);
                    nodes.push(root);
                }
            }
        }
        return root;
    }
    private static int getVal(String s){
        StringBuilder num=new StringBuilder();
        boolean positive=true;
        char ch=s.charAt(i);
        if(ch=='-'){
            i++;
            positive=false;
        }
        while(i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9')){
            num.append(s.charAt(i++));
        }
        int temp=Integer.valueOf(num.toString());
        return positive==true?temp:-temp;
    }

    public static String  inOrder2(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if (root != null) {
            inOrder2(root.left);
            sb.append(root.val);
            inOrder2(root.right);
        }
        return sb.toString();
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        //res = solution(_input);
        TreeNode root=str2tree(_input);
        res=inOrder2(root);
        System.out.println(res);
    }

    static String solution(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int len = s.length();
        stack.push(s.charAt(0)-'0');

        while(i < len){
            if(s.charAt(i) == '('){
                i++;
            }
            else if(s.charAt(i) == ','){
                if(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                if(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                i++;
            }
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                i++;
            }
            else{
                stack.push(s.charAt(i)-'0');
                i++;
            }

        }
        return sb.toString();

    }
}
