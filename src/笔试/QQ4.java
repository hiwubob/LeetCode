package ±  ‘;

import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class QQ4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] ans = new int[n];
        for(int i =0 ;i <n; i++){
            nums[i] = sc.nextInt();
        }
        for(int i =0 ;i <n; i++){
            ans[i] = see(nums,i);
        }
        for(int i =0 ;i <n-1; i++){
            System.out.print(ans[i]);
            System.out.print(" ");
        }
        System.out.println(ans[n-1]);
    }


    public static int see(int[] nums, int i ){
        if(nums.length == 1)return 1;
        if(nums.length == 2)return 2;
        int n = nums.length;
        int ans = 1;
        if(i == 0){
            int lo = 2;
            ans++;
            int stan = nums[1];
            while(lo<nums.length){
                if(nums[lo] > stan){
                    ans++;
                    stan = nums[lo];
                }
                lo++;
            }
        }
        else if( i == nums.length-1){
            int hi = n-3;
            ans++;
            int stan = nums[n-2];
            while(hi>=0){
                if(nums[hi] > stan){
                    ans++;
                    stan = nums[hi];
                }
                hi--;
            }
        }
        else{
            ans = 3;
            int lo = i+2,hi = i-2;
            int stan = nums[i+1];
            while(lo>=0 && lo<n){
                if(nums[lo] > stan){
                    ans++;
                    stan = nums[lo];
                }
                lo++;
            }
            stan = nums[i-1];
            while(hi <n && hi>=0){
                if(nums[hi] > stan){
                    ans++;
                    stan = nums[hi];
                }
                hi--;
            }
        }
        return ans;
    }


}