package 笔试;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        ListNode s=null;
        ListNode b=null;
        ListNode sl=null;
        ListNode bl=null;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            if(cur.val<m){
                if(s==null){
                    s=cur;
                }
                else{
                    sl.next=cur;
                }
                sl=cur;
            }
            else{
                if(b==null){
                    b=cur;
                }
                else{
                    bl.next=cur;
                }
                bl=cur;
            }
        }
        if(s==null){
            return b;
        }
        else{
            sl.next=b;
            if(bl!=null){
                bl.next=null;
            }
            return s;
        }

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
